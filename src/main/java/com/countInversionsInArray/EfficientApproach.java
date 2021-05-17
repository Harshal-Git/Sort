/**
 * 
 */
package com.countInversionsInArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Count number of inversions in a given array. Inversion is considered if a pair from given array, (a[i], a[j]) is formed such
 *		that i < j AND a[i] > a[j].
 *
 *	-> efficient approach : merge sort based algo to count inversions
 *
 *	-> ex:
 *		  i/p: {2, 4, 1, 3, 5} => o/p: 3 [(4, 1), (4, 3), (2, 1)]
 *
 *		  i/p: {10, 20, 30, 40} => o/p: 0 [no such inversion pairs can be made with an ascending sorted array]
 *
 *		  i/p: {40, 30, 20, 10} => o/p: 6 [(40, 30), (40, 20), (40, 10), (30, 20), (30, 10), (20, 10)]
 *
 * -> Time complexity:	O(n * log n) 
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(n)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {2, 4, 1, 3, 5};
		System.out.println("Array: "+Arrays.toString(data1)+": inversions => "+getInversions(data1));

		int [] data2 = {10, 20, 30, 40};
		System.out.println("\nArray: "+Arrays.toString(data2)+": inversions => "+getInversions(data2));

		int [] data3 = {40, 30, 20, 10};
		System.out.println("\nArray: "+Arrays.toString(data3)+": inversions => "+getInversions(data3));
		
		int [] data4 = {2, 5, 8, 11, 3, 6, 9, 13};
		System.out.println("\nArray: "+Arrays.toString(data4)+": inversions => "+getInversions(data4));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int getInversions(int[] data) {
		return countInversions(data, 0, (data.length-1));
	}

	/**
	 * @param data
	 * @param start
	 * @param end
	 * @return
	 */
	private static int countInversions(int[] data, int start, int end) {
		int inversionCount = 0;
		if(start < end) {
			int mid = (start+((end-start)/2));
			inversionCount+= countInversions(data, start, mid);
			inversionCount+= countInversions(data, (mid+1), end);
			inversionCount+= countInversionsAndMerge(data, start, mid, end);
		}
		return inversionCount;
	}

	/**
	 * @param data
	 * @param start
	 * @param mid
	 * @param end
	 * @return
	 */
	private static int countInversionsAndMerge(int[] data, int start, int mid, int end) {

		// sub arrays initializations
		int leftSize = ((mid-start)+1);
		int rightSize = (end-mid);
		int indexArr = 0;

		// prepare left array
		int [] leftArr = new int[leftSize];
		for(int index = start; index <= mid; index++) {
			leftArr[indexArr] = data[index];
			indexArr++;
		}

		// prepare right array
		int [] rightArr = new int[rightSize];
		indexArr = 0;
		for(int index = (mid+1); index <= end; index++) {
			rightArr[indexArr] = data[index];
			indexArr++;
		}

		// merge both arrays in sorted manner and count inversions
		int inversionCount = 0;
		int leftIndex = 0, rightIndex = 0;
		indexArr = start;
		while(indexArr <= end) {
			// if arrays stays within the limit : compare & insert into the main array
			if((leftIndex < leftSize) && (rightIndex < rightSize)) {
				if(leftArr[leftIndex] <= rightArr[rightIndex]) {
					// if left array element is smaller
					data[indexArr] = leftArr[leftIndex];
					leftIndex++;
				} else {
					// if right array element is smaller
					data[indexArr] = rightArr[rightIndex];
					rightIndex++;
					/*
					 * Inversion calculation
					 * if any element we find in left array is greater than right array; 
					 * that means the element & all further elements in the left array 
					 * are higher and will form inversion pairs with the same right array. 
					 * Hence we can directly calculate multiple inversion pairs with this formula.
					 */
					inversionCount+= (leftSize-leftIndex);
				}
			} else if(leftIndex < leftSize){
				// if right array is exhausted
				data[indexArr] = leftArr[leftIndex];
				leftIndex++;

			} else {
				// if left array is exhausted
				data[indexArr] = rightArr[rightIndex];
				rightIndex++;
			}
			indexArr++;
		}
		return inversionCount;
	}
}