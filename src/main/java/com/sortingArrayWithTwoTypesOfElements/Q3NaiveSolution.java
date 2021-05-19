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
 *	-> this is naive approach: applicable to all variations with slight modification of conditions.
 *
 * -> Time complexity:	0(n)+0(n)+0(n) ~ 0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(n)
 */
public class Q3NaiveSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 1, 1, 1, 0};
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
			if(data[index] == 0) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// later put all ODD numbers 
		for(int index = 0; index < size; index++) {
			if(data[index] == 1) {
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
