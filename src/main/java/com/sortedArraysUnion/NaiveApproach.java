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
 *	-> naive approach : put both arrays one by one in a temp array. sort the temp array and print elements from that array without
 *						duplicates. 
 *
 *	ex:
 *		i/p : a1 = {3, 5, 8} & a2 = {2, 8, 9, 10, 15}	=> o/p : 2 3 5 8 9 10 15
 *
 *		i/p : a1 = {2, 3, 3, 3, 4, 4} & a2 = {4, 4}	=> o/p : 2 3 4
 *
 * -> Time complexity:	0(m) + 0(n) + 0((m+n) * log(m+n)) + 0(m+n) ~ 0((m+n) * log(m+n))  
 * -> Space complexity:	0(m+n)
 * -> Auxiliary space: 0(m+n)
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
		System.out.print("Intersection of both arrays: ");
		printUnionOfArrays(data1, data2);
		System.out.println();
	}

	/**
	 * @param data1
	 * @param data2
	 */
	private static void printUnionOfArrays(int[] data1, int[] data2) {

		int size1 = data1.length;
		int size2 = data2.length;
		int [] temp = new int[size1+size2];
		int tempIndex = 0;

		// put array1 data into temp array
		for(int index = 0; index < size1; index++) {
			temp[tempIndex] = data1[index];
			tempIndex++;
		}

		// put array2 data into temp array
		for(int index = 0; index < size2; index++) {
			temp[tempIndex] = data2[index];
			tempIndex++;
		}

		// sort complete temp array
		Arrays.sort(temp);

		// print elements such that no duplicates are printed
		for(int index = 0; index < temp.length; index++) {
			if(index == 0 || temp[index] != temp[index-1]) {
				System.out.print(temp[index]+" ");
			}
		}
	}
}