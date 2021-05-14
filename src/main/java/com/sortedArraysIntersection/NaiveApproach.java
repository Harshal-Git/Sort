/**
 * 
 */
package com.sortedArraysIntersection;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 sorted arrays (might contain duplicates). Find common elements in both arrays. Duplicates needs not to be repeated 
 *		in final result.
 *
 *	-> Naive approach : Iterate through all elements from one array and for each element; check whether matching element exist in the
 *						right side array?   
 *
 *	-> This will work for any types of arrays (sorted / Unsorted). Output will no longer be sorted.
 *
 *	-> ex:
 *
 *		i/p : a1 = {3, 5, 10, 10, 10, 15, 15, 20} & a2 = {5, 10, 10, 15, 30};
 *		o/p = 5 10 15
 *
 *		i/p : a1 = {1, 1, 3, 3, 3} & a2 = {1, 1, 1, 1, 3, 5, 7};
 *		o/p = 1 3
 *
 * -> Time complexity:	O(m*n) ~ O(n^2) 
 * -> Space complexity:	O(m+n)
 * -> Auxiliary space: 0(1)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {3, 5, 10, 10, 10, 15, 15, 20};
		int [] data2 = {5, 10, 10, 15, 30};
		printMessage(data1, data2);

		int [] data3 = {1, 1, 3, 3, 3, 7};
		int [] data4 = {1, 1, 1, 1, 3, 5, 7};
		printMessage(data3, data4);

		int [] data5 = {10, 5, 7, 9, 1, 3, 6};
		int [] data6 = {6, 8, 10, 2, 4};
		printMessage(data5, data6);

		int [] data7 = {2, 20, 20, 40, 60};
		int [] data8 = {10, 20, 20, 20};
		printMessage(data7, data8);
		
		int [] data9 = {3, 5, 8};
		int [] data10 = {2, 8, 9, 10, 15};
		printMessage(data9, data10);
		
		int [] data11 = {3, 3, 3, 2, 4, 4};
		int [] data12 = {4, 4};
		printMessage(data11, data12);
	}

	/**
	 * @param data1
	 * @param data2
	 */
	private static void printMessage(int[] data1, int[] data2) {
		System.out.println("\nArray 1: "+Arrays.toString(data1));
		System.out.println("Array 2: "+Arrays.toString(data2));
		System.out.print("Intersection of both arrays: ");
		printIntersectionOfArrays(data1, data2);
		System.out.println();
	}

	/**
	 * @param data1
	 * @param data2
	 */
	private static void printIntersectionOfArrays(int[] data1, int[] data2) {

		int size1 = data1.length;
		int size2 = data2.length;

		// iterate through first array
		for(int index1 = 0; index1 < size1; index1++) {
			// if subsequent elements exist in array; ignore such elements as those are already processed
			if(index1 > 0 && data1[index1] == data1[index1-1]) {
				continue;
			} else {
				// iterate through second array
				for(int index2 = 0; index2 < size2; index2++) {
					// match elements from both arrays
					if(data1[index1] == data2[index2]) {
						System.out.print(data1[index1]+" ");
						break;	// break loop to print elements only once in case duplicates are present.
					}
				}
			}
		}
	}
}