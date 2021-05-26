/**
 * 
 */
package com.insertionSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Naive approach for Insertion sort : Stable algo
 *
 *	-> Iterate array elements and find a correct position where the elements can be placed. Keep shifting elements towards
 *		right side of the array if any element needs to be inserted in-between.
 *
 *	-> Java standard sort function (Arrays.sort - for wrapper class arrays) uses Insertion sort for smaller data size (< 7) 
 *		and for rest it uses merge sort.
 *
 * 	-> For primitive arrays; it uses Dual pivot quick sort.
 * 
 * 	-> Time complexity: O(n^2) => Best case 0(n) [when sorted array is given] & Worst case 0(n^2) 
 * 								[when reverse sorted array is given]	
 * 	-> Space complexity:	O(n)
 * 	-> Auxiliary space: O(1)
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {4, 3, 2, 1};
		printMessage(data1);

		int [] data2 = {1, 3, 5, 7, 2, 4, 6};
		printMessage(data2);
		
		int [] data3 = {20, 5, 40, 60, 10, 30};
		printMessage(data3);
		
		int [] data4 = {1, 2, 3, 4};
		printMessage(data4);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nOriginal array: "+Arrays.toString(data));
		insertionSort(data);
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void insertionSort(int[] data) {
		int size = data.length;
		int keyToSort = -1;
		int shiftIndex;
		// iterate over elements 
		for(int index = 1; index < size; index++) {
			// get a new key to sort
			keyToSort = data[index];
			// now from current position; traverse reverse and find whether 
			// array elements are greater than current key; shift all such elements.
			shiftIndex = (index-1);
			/*
			 * extra information: because of the '>' and not '>=' sign, this algo is 
			 * stable sorting algo. Otherwise when arrays are duplicate, it will change
			 * the order of the same elements before putting it besides each other.
			 */
			while((shiftIndex >= 0) && (data[shiftIndex] > keyToSort)) {
				data[shiftIndex+1] = data[shiftIndex];
				shiftIndex--;
			}
			// the moment shifting is over; we have 
			// correct position to insert the sorted key.
			data[shiftIndex+1] = keyToSort;
		}
	}
}
