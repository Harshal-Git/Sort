/**
 * 
 */
package com.sortingArrayWithTwoTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Give an array with positive numbers and we need to sort the array in such a way that all EVEN numbers comes on left
 *		side & all ODD numbers comes on right side. The complete array needs not to be sorted as a whole.
 *
 *	-> ex:
 *			i/p: {15, 14, 13, 12} => o/p : {14, 12, 15, 13}
 *
 *	-> this is naive approach: applicable to all variations with slight modification of conditions.
 *
 * -> Time complexity:	0(n)+0(n)+0(n) ~ 0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(n)
 */
public class Q2NaiveSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {15, 14, 13, 12};
		printMessage(data1);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		sortArray(data);
		System.out.println("\nArray after sorting: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void sortArray(int[] data) {
		int size = data.length;
		int [] temp = new int[size];
		int tempIndex = 0;

		// as per the condition, first put all EVEN numbers
		for(int index = 0; index < size; index++) {
			if((data[index] % 2) == 0) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// later put all ODD numbers 
		for(int index = 0; index < size; index++) {
			if((data[index] % 2) != 0) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// put data back to original array
		for(int index = 0; index < size; index++) {
			data[index] = temp[index];
		}
	}

}
