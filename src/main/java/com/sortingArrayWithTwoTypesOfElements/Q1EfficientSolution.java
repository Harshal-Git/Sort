/**
 * 
 */
package com.sortingArrayWithTwoTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Give an array with real numbers(+ve & -ve) and we need to sort the array in such a way that all negatives comes on left
 *		side & all positives comes on right side. The complete array needs not to be sorted as a whole.
 *
 *	-> ex:
 *			i/p: {13, -12, 18, -10}	=> o/p : {-12, -10, 13, 18}
 *
 *	-> we can perform Hoare's partition which will arrange the elements as asked.
 *
 * -> Time complexity: O(n) 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 * 
 */
public class Q1EfficientSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {13, -12, 18, -10};
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
			
			// perform left search for negative elements
			do {
				start++;
			} while(data[start] < 0);
			
			// perform right search for positive elements
			do {
				end--;
			} while(data[end] >= 0);
			
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
