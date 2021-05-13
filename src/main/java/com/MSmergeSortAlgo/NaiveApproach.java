/**
 * 
 */
package com.MSmergeSortAlgo;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Merge sort : Stable algo
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
		insertionSort(data);
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void insertionSort(int[] data) {
		// TODO Auto-generated method stub

	}
}
