/**
 * 
 */
package com.sortingArrayWithTwoTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Give a binary array and we need to sort the array in such a way that all 0s comes on left side & 
 *		all 1s comes on right side. 
 *
 *	-> ex:
 *			i/p: {0, 1, 1, 1, 0} => o/p : {0, 0, 1, 1, 1}
 *
 *	-> we can perform Hoare's partition which will arrange the elements as asked.
 *
 * -> Time complexity: O(n) 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 * 
 */
public class Q3EfficientSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 1, 1, 1, 0};
		printMessage(data1);

	}

	/**
	 * @param data1
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		sortArray(data);
		System.out.println("\nArray after sorting: "+Arrays.toString(data));
	}

	/**
	 * Hoare's partition
	 * @param data
	 */
	private static void sortArray(int[] data) {

		int size = data.length;
		int start = -1;
		int end = size;	// index starts from 0

		while(start <= end) {

			// perform left search for EVEN numbers
			do {
				start++;
			} while(data[start] == 0);

			// perform right search for ODD numbers
			do {
				end--;
			} while(data[end] == 1);

			// if they match OR crosses each other; do nothing
			if(start >= end) {
				return;
			}
			// swap such elements
			swap(data, start, end);
		}
	}

	/**
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void swap(int[] data, int start, int end) {
		int temp = data[start];
		data[start] = data[end];
		data[end] = temp;
	}
}
