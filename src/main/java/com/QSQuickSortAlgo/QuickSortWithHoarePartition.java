/**
 * 
 */
package com.QSQuickSortAlgo;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Quick sort algo with Hoare's partition
 *
 *	-> algo: 
 *			quickSort(arr[], left, right) {
 *
 *				if(left < right) {
 *				
 *				int pivotIndex = hoarePartition(arr, left, right);
 *				
 *				quickSort(arr, left, pivotIndex);
 *	
 *				quickSort(arr, (pivotIndex+1), right);
 *
 *				}
 *			}
 *
 *	-> this algo is in-place, cache friendly, has average case as 0(n * log n), tail recursive
 *
 * -> Time complexity:	average case => 0(n * log n) & worst case O(n^2)	
 * -> Space complexity:	O(n) [for array] + O(n) [for call stack] ~ O(n)
 * -> Auxiliary space:	
 * 						for worst case => 0(1) [for Hoare] + O(n) [for call stack] ~ O(n)
 * 						for best case => 0(log n) 
 */
public class QuickSortWithHoarePartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1= {8, 4, 7, 9, 3, 10, 5};
		printMessage(data1);

		int [] data2= {3, 9, 5, 7, 0, 4, 2};
		printMessage(data2);
	}

	/**
	 * @param data1
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		quickSort(data, 0, (data.length-1));
		System.out.println("Sorted Array: "+Arrays.toString(data));
	}

	/**
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void quickSort(int[] data, int start, int end) {
		if(start < end) {
			// hoare's partition
			int pivotIndex = hoarePartition(data, start, end);
			// left sort
			quickSort(data, start, pivotIndex);
			// right sort
			quickSort(data, (pivotIndex+1), end);
		}
	}	

	/**
	 * find partition 
	 * @param data
	 * @param start
	 * @param end
	 * @param pIndex
	 */
	private static int hoarePartition(int[] data, int start, int end) {

		// prepare pivot element
		int pivotElement = data[start];

		// prepare traversal pointers
		int leftPtr = (start-1);
		int rightPtr = (end+1);

		// iterate over elements
		while(true) {

			// find smaller element than pivot in left side
			do {
				leftPtr++;
			} while(data[leftPtr] < pivotElement);

			// find higher element than pivot in right side
			do {
				rightPtr--;
			} while(data[rightPtr] > pivotElement);

			// if both pointers crosses each other; return right pointer
			if(leftPtr >= rightPtr) {
				return rightPtr;
			}
			// swap elements for left & right pointer 
			swap(data, leftPtr, rightPtr);
		}
	}

	/**
	 * 
	 * @param data
	 * @param pos1
	 * @param pos2
	 */
	private static void swap(int[] data, int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
}
