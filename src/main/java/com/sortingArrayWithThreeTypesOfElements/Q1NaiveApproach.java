/**
 * 
 */
package com.sortingArrayWithThreeTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Sort the given array of 0s, 1s, & 2s as such that 0s comes first, then 1s and then 2s.
 *
 * 	-> naive approach : multiple iteration & pick each element for each iteration
 * 
 * 	-> ex:
 * 		i/p: {0, 1, 0, 2, 1, 2}	=> o/p: {0, 0, 1, 1, 2, 2}
 * 
 * -> Time complexity: 0(n)+0(n)+0(n)+0(n) ~ 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 */
public class Q1NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 1, 0, 2, 1, 2, 1, 2, 2};
		printMessage(data1);

	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		partitionArray(data);
		System.out.println("Partitioned Array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void partitionArray(int[] data) {
		int size = data.length;

		int [] temp = new int[size];
		int tempIndex = 0;

		// process 0s
		for(int index = 0; index < size; index++) {
			if(data[index] == 0) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// process 1s
		for(int index = 0; index < size; index++) {
			if(data[index] == 1) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// process 2s
		for(int index = 0; index < size; index++) {
			if(data[index] == 2) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// copy data back to original array
		for(int index = 0; index < size; index++) {
			data[index]=temp[index];
		}
	}

}
