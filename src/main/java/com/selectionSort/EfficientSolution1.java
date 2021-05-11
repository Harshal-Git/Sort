/**
 * 
 */
package com.selectionSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Efficient approach for selection sort
 * 
 *	-> For each iteration, keep finding lowest element from remaining array elements and once we find such lowest element; 
 *		swap it with current index.
 *
 *	-> This process will keep creating window of sorted elements with every iteration on the left side of the array.  
 *	   With every further iteration; this window needs not to be processed. 
 *
 * -> Time complexity: 0(n^2)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1) 
 * 
 */
public class EfficientSolution1 {

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
		int lowestIndex = 0;
		// iterate over all elements
		for(int index = 0; index < size; index++) {
			// for each iteration; reset the lowest 
			lowestIndex = index;
			/*
			 * iterate over all remaining elements and find lowest element index
			 * and also not processing left most elements window which is sorted.
			 */
			for(int count = (index+1); count < size; count++) {
				if(data[lowestIndex] > data[count]) {
					lowestIndex = count;
				}
			}
			// swap lowest element index & current index
			swap(data, lowestIndex, index);
		}
	}

	/**
	 * @param data
	 * @param lowestIndex
	 * @param index
	 */
	private static void swap(int[] data, int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
}
