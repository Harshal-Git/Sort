/**
 * 
 */
package com.sortingArrayWithThreeTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Partition the given array around a given range in such a way that all elements from given range's smallest element comes
	on left & other elements comes on right. Range has 2 point {a, b} where a <= b.
 *
 * 	-> naive approach : multiple iteration & pick each element for each iteration from given range.
 * 
 * 	-> ex:
 * 		i/p: {10, 5, 6, 3, 20, 9, 40} & range = [5, 10]	=> o/p: {3, 5, 6, 9, 10, 20, 40} 
 * 
 * -> Time complexity: 0(n)+0(n)+0(n)+0(n) ~ 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 */
public class Q3NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 5, 6, 3, 20, 9, 40};
		int [] range = {5, 10};
		printMessage(data1, range);

	}

	/**
	 * @param data
	 * @param range 
	 */
	private static void printMessage(int[] data, int[] range) {
		System.out.println("\nArray: "+Arrays.toString(data)+" -> Pivot: "+Arrays.toString(range));
		partitionArray(data, range);
		System.out.println("Partitioned Array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 * @param range[] 
	 */
	private static void partitionArray(int[] data, int[] range) {
		int size = data.length;

		int [] temp = new int[size];
		int tempIndex = 0;

		// process < range
		for(int index = 0; index < size; index++) {
			if(data[index] < range[0]) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// process in-between range
		for(int index = 0; index < size; index++) {
			if((data[index] >= range[0]) && (data[index] < range[1])) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// process more than range
		for(int index = 0; index < size; index++) {
			if(data[index] >= range[1]) {
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
