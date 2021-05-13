/**
 * 
 */
package com.bubbleSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Bubble sort : Stable algo
 *
 * -> Time complexity: O(n^2)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space:  O(1)
 */
public class NaiveApproach {

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
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nOriginal array: "+Arrays.toString(data));
		bubbleSort(data);
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * bubble sort
	 * @param data
	 */
	private static void bubbleSort(int[] data) {
		int size = data.length;
		for(int index = 0; index < (size-1); index++) {
			for(int count = 0; count < (size-1); count++) {
				/*
				 * swap when i < (i+1) => descending order
				 * 
				 * swap when i > (i+1) => ascending order
				 */
				if(data[count] > data[count+1]) {
					swap(data, count, (count+1));
				}
			}
		}
	}

	/**
	 * swap elements for given positions
	 * @param data
	 * @param pos1
	 * @param pos2
	 */
	private static void swap(int [] data, int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
}
