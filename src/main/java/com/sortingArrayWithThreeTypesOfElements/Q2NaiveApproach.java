/**
 * 
 */
package com.sortingArrayWithThreeTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Partition the given element with given pivot point such that all smaller elements should be on left of the pivot 
 *		and higher on right side of the pivot. If multiple occurrences are there for pivot, they all need to be consecutive.
 *
 * 	-> naive approach : multiple iteration & pick each element in each iteration.
 * 
 * 	-> ex:
 * 		i/p: {2, 1, 2, 20, 10, 20, 1} & pivot = 2 => o/p: {1, 1, 2, 2, 20, 10, 20}
 * 
 * -> Time complexity: 0(n)+0(n)+0(n)+0(n) ~ 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 */
public class Q2NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int pivot;

		int [] data1 = {2, 1, 2, 20, 10, 20, 1};
		pivot = 2;
		printMessage(data1, pivot);

	}

	/**
	 * @param data
	 * @param pivot 
	 */
	private static void printMessage(int[] data, int pivot) {
		System.out.println("\nArray: "+Arrays.toString(data)+" -> Pivot: "+pivot);
		partitionArray(data, pivot);
		System.out.println("Partitioned Array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 * @param pivot 
	 */
	private static void partitionArray(int[] data, int pivot) {
		int size = data.length;

		int [] temp = new int[size];
		int tempIndex = 0;

		// process (< pivot)
		for(int index = 0; index < size; index++) {
			if(data[index] < pivot) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// process (== pivot)
		for(int index = 0; index < size; index++) {
			if(data[index] == pivot) {
				temp[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// process (> pivot)
		for(int index = 0; index < size; index++) {
			if(data[index] > pivot) {
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
