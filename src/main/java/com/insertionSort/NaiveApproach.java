/**
 * 
 */
package com.insertionSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Naive approach for Insertion sort
 *
 *	-> Iterate array elements and find a correct position where the elements can be placed. Keep shifting elements towards
 *		right side of the array if any element needs to be inserted inbetween.
 *
 */
public class NaiveApproach {

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
