/**
 * 
 */
package com.MSmergeSortAlgo;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Merge sort : Stable algo : suitable for linked list sorting.
 *	
 *	-> Merge sort algorithm: this is based on divide & conquer approach and hence it will be a recursive call.
 *
 *	-> Java standard sort function (Arrays.sort - for wrapper class arrays) uses Insertion sort for smaller data size (< 7) 
 *		and for rest it uses merge sort.
 *
 * 	-> For primitive arrays; it uses Dual pivot quick sort.
 *
 *	-> Algo: 
 *
 *			mergeSort(data, start, end) {
 *				if(start < end) {
 *
 *					find mid;
 *
 *					// recursive call to function with different indexes
 *					mergeSort(start, mid);	
 *					mergeSort(mid+1, end);	
 *
 *					// merge two sorted arrays [from (start -> mid) and ((mid+1) -> end)]
 *					merge(start, mid, end);	
 *				}
 *			}
 *
 * -> Time complexity: 0(n * log n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 * 
 * 	-> In this algo, space complexity can be improved if creation of left & right sub array in the merge function can be reduced.
 * 		So preparing common left & right sub arrays & using them at each merge function call might slightly improve the performance.   
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 3, 5, 7, 2, 4, 6};
		printMessage(data1);

		int [] data2 = {10, 8, 6, 4, 2, 0};
		printMessage(data2);

		int [] data3 = {10, 8, 20, 5};
		printMessage(data3);

		int [] data4 = {4, 3, 2, 1};
		printMessage(data4);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nOriginal array: "+Arrays.toString(data));
		mergeSort(data, 0, (data.length-1));
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * actual merge sort function which gets called recursively
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[] data, int start, int end) {
		// prepare mid point
		int mid;
		if(start < end) {

			// find mid point
			mid = (start+((end-start)/2));

			// perform merge-sort on left half
			mergeSort(data, start, mid);

			// perform merge-sort on right half
			mergeSort(data, (mid+1), end);

			// merge both sorted array
			merge(data, start, mid, end);
		}
	}

	/**
	 * merge function which will actually merge the sorted 
	 * array present with given range 
	 * @param data
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void merge(int[] data, int start, int mid, int end) {
		// prepare left sub array
		int [] leftArr = new int[((mid-start)+1)];
		int subArrIndex = 0;
		for(int index = start; index <= mid; index++) {
			leftArr[subArrIndex++] = data[index];
		}

		// prepare right sub array
		subArrIndex = 0;
		int [] rightArr = new int[end-mid];
		for(int index = (mid+1); index <= end; index++) {
			rightArr[subArrIndex++] = data[index];
		}

		// merge both sorted arrays into original array
		int leftSize = leftArr.length;
		int leftIndex = 0;

		int rightSize = rightArr.length;
		int rightIndex = 0;

		/*
		 * as current array is sub array of existing array; we have to 
		 * use existing 'start' and 'end' points to complete the merge 
		 * process. It will vary based on each part of the sub array.
		 */
		subArrIndex = start;
		while(subArrIndex <= end) {
			// if both array has data
			if((leftIndex < leftSize) && (rightIndex < rightSize)) {
				if(leftArr[leftIndex] <= rightArr[rightIndex]) {
					// put left array elements into original array
					data[subArrIndex++] = leftArr[leftIndex++];
				} else {
					// put right array elements into original array
					data[subArrIndex++] = rightArr[rightIndex++];
				}
			} else if(leftIndex < leftSize) {
				// right array is exhausted
				data[subArrIndex++] = leftArr[leftIndex++];
			} else {
				// left array is exhausted
				data[subArrIndex++] = rightArr[rightIndex++];
			}
		}
	}
}