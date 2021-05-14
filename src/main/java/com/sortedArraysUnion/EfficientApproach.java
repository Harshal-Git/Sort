/**
 * 
 */
package com.sortedArraysUnion;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> print union of sorted arrays. It cannot contain duplicates (if any) and the resulting arrays also needs to be sorted.
 *
 *	-> efficient approach : this will work only in the case when both arrays are sorted. 
 *
 *	ex:
 *		i/p : a1 = {3, 5, 8} & a2 = {2, 8, 9, 10, 15}	=> o/p : 2 3 5 8 9 10 15
 *
 *		i/p : a1 = {2, 3, 3, 3, 4, 4} & a2 = {4, 4}	=> o/p : 2 3 4
 *
 *
 * -> Time complexity:	O(m+n)
 * -> Space complexity:	O(m+n)
 * -> Auxiliary space: O(1)
 */
public class EfficientApproach {

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

		int [] data5 = {1, 3, 5, 7, 9};
		int [] data6 = {2, 4, 6, 8, 10};
		printMessage(data5, data6);

		int [] data7 = {2, 20, 20, 40, 60};
		int [] data8 = {10, 20, 20, 20};
		printMessage(data7, data8);

		int [] data9 = {3, 5, 8};
		int [] data10 = {2, 8, 9, 10, 15};
		printMessage(data9, data10);

		int [] data11 = {2, 3, 3, 3, 4, 4};
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
		System.out.print("Union of both arrays: ");
		printUnionOfArrays(data1, data2);
		System.out.println();
	}

	/**
	 * @param data1
	 * @param data2
	 */
	private static void printUnionOfArrays(int[] data1, int[] data2) {

		int size1 = data1.length;
		int index1 = 0;

		int size2 = data2.length;
		int index2 = 0;

		// till either of the array gets exhausted; keep printing data in sorted order
		while((index1 < size1) && (index2 < size2)) {

			// ignore duplicate elements from both arrays
			if(index1 > 0 && data1[index1] == data1[index1-1]) {
				index1++;
				continue;
			}
			if(index2 > 0 && data2[index2] == data2[index2-1]) {
				index2++;
				continue;
			}

			// if first array has smaller element
			if(data1[index1] < data2[index2]) {
				System.out.print(data1[index1]+" ");
				index1++;
			} else if(data1[index1] > data2[index2]) {
				// if second array has smaller element
				System.out.print(data2[index2]+" ");
				index2++;
			} else {
				// if both are same
				System.out.print(data1[index1]+" ");
				index1++;
				index2++;
			}
		}
		// print remaining elements from array1 - excluding duplicates
		for(int index = index1; index < size1; index++) {
			if(data1[index-1] != data1[index]) {
				System.out.print(data1[index]+" ");	
			}
		}
		// print remaining elements from array2 - excluding duplicates
		for(int index = index2; index < size2; index++) {
			if(data2[index-1] != data2[index]) {
				System.out.print(data2[index]+" ");	
			}
		}
	}

}
