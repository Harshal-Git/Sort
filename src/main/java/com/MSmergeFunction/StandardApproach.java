/**
 * 
 */
package com.MSmergeFunction;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> An array is given with 3 elements called (low, mid, high) (low <= mid < high). In the given array, elements from low -> mid and
 *		 (mid+1) -> high are independently sorted but the full array is not sorted. We need to sort full array.
 *
 *  -> This is merge function of the Merge sort algorithm; where single array is virtually divided into sub arrays which are sorted
 *  	and this function will combine both arrays in sorted manner.
 *  
 *  ex:
 *  	i/p: {10, 15, 20, 11, 30} & (0, 2, 4) => this means elements from 0 -> 2 are sorted and 3-> 4 are sorted. 
 *  	o/p: {10, 11, 15, 20, 30}
 *  
 * 		i/p: {5, 8, 12, 14, 7} & (0, 3, 4) => o/p: {5, 7, 8, 12, 14}
 * 
 *  	i/p: {10, 15, 20, 40, 8, 11, 55} & (0, 3, 6) => o/p: {8, 10, 11, 15, 20, 40, 55} 		
 * 
 * -> Time complexity: 0(high-low)	~ 0(n) - 'n' stands for given array size
 * -> Space complexity:	0(high-low) ~ 0(n)
 * -> Auxiliary space: 0(high-low) ~ 0(n)
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int low, mid, high;

		int [] data1 = {10, 15, 20, 11, 30};
		low = 0; mid = 2; high = 4;
		printMessage(data1, low, mid, high);

		int [] data2 = {5, 8, 12, 14, 7};
		low = 0; mid = 3; high = 4;
		printMessage(data2, low, mid, high);

		int [] data3 = {10, 15, 20, 40, 8, 11, 55};
		low = 0; mid = 3; high = 6;
		printMessage(data3, low, mid, high);

		int [] data4 = {10, 8};
		low = 0; mid = 0; high = 1;
		printMessage(data4, low, mid, high);
	}

	/**
	 * @param high 
	 * @param mid 
	 * @param low 
	 * @param data1
	 */
	private static void printMessage(int[] data, int low, int mid, int high) {
		System.out.println("\nArray: "+Arrays.toString(data));
		System.out.println("low = "+low+", mid = "+mid+", high = "+high);
		performMergeFunction(data, low, mid, high);
		System.out.println("Array after merge: "+Arrays.toString(data));
	}

	/**
	 * prepare 2 sub arrays parted by (low / mid) & (mid+1 / high) and 
	 * merge them in sorted manner.
	 *  
	 * @param data
	 * @param high 
	 * @param mid 
	 * @param low 
	 */
	private static void performMergeFunction(int[] data, int low, int mid, int high) {

		int size = data.length;
		int leftSize = ((mid-low)+1);
		int rightSize = (high-mid);

		// prepare left & right sub arrays
		int [] leftArr = new int[leftSize];
		int [] rightArr = new int[rightSize];
		int subArrayIndex = 0, leftIndex = 0, rightIndex = 0;

		// prepare left array (from low to mid)
		for(int index = low; index <= mid; index++) {
			leftArr[subArrayIndex] = data[index];
			subArrayIndex++;
		}
		subArrayIndex = 0;
		// prepare right array (from (mid+1) to high)
		for(int index = (mid+1); index <= high; index++) {
			rightArr[subArrayIndex] = data[index];
			subArrayIndex++;
		}

		// merge both sorted array into original array
		subArrayIndex = 0;	 
		while(subArrayIndex < size) {
			// if both arrays has data : keep comparing 
			// & adding into original array in sorted manner
			if((leftIndex < leftSize) && (rightIndex < rightSize)) {
				if(leftArr[leftIndex] <= rightArr[rightIndex]) {
					data[subArrayIndex] = leftArr[leftIndex];
					leftIndex++;
				} else {
					data[subArrayIndex] = rightArr[rightIndex];
					rightIndex++;
				}
			} else if(rightIndex < rightSize){
				// if left sub array is exhausted
				data[subArrayIndex] = rightArr[rightIndex];
				rightIndex++;
			} else {
				// if right sub array is exhausted
				data[subArrayIndex] = leftArr[leftIndex];
				leftIndex++;
			}
			subArrayIndex++;
		}
	}
}
