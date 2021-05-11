/**
 * 
 */
package com.selectionSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Naive approach for selection sort
 *
 *	-> Keep finding lowest element from current array and put the lowest in a temporary array. And replace the lowest with a 
 *		Integer.MAX_VALUE value; so that for next iteration; other lowest element will be considered.
 *
 *		At the end, copy all elements from temporary array into original array.
 *
 * -> Time complexity: 0(n^2)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(n) - for temp array
 * 
 */
public class NaiveSolution {

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
		selectionSort(data);
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void selectionSort(int[] data) {

		int size = data.length;
		int [] temp = new int[size];
		int lowestIndex = 0;

		for(int index = 0; index < size; index++) {
			// for each iteration; reset the lowest element as it's already 
			// replaced with MAX_VALUE
			lowestIndex = 0;
			// iterate over all elements and find lowest element index
			for(int count = 1; count < size; count++) {
				if(data[lowestIndex] > data[count]) {
					lowestIndex = count;
				}
			}
			// put lowest element in temp array at given index
			temp[index] = data[lowestIndex];
			// in actual array; replace lowest index element with +ve INF
			data[lowestIndex] = Integer.MAX_VALUE;
		}
		// at the end; copy temp array into original array
		for(int index = 0; index < size; index++) {
			data[index] = temp[index];
		}
	}
}
