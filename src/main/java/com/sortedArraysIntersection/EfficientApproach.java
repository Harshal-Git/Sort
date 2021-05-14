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
 *	-> Efficient approach : Iterate through elements in both arrays and if element matches in both; print it. Otherwise keep 
 *							reading further elements for the array in which element is smaller.  
 *
 *	-> This will work only when both arrays are sorted.
 *
 *	-> ex:
 *
 *		i/p : a1 = {3, 5, 10, 10, 10, 15, 15, 20} & a2 = {5, 10, 10, 15, 30};
 *		o/p = 5 10 15
 *
 *		i/p : a1 = {1, 1, 3, 3, 3} & a2 = {1, 1, 1, 1, 3, 5, 7};
 *		o/p = 1 3
 *
 * -> Time complexity:	0(m+n)
 * -> Space complexity:	0(m+n)
 * -> Auxiliary space: 0(1)
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
		int index1 = 0, index2 = 0;

		// read till either of the array gets exhausted
		while(index1 < size1 && index2 < size2) {
			// if subsequent elements exist in array; ignore such elements as those are already processed
			if(index1 > 0 && data1[index1] == data1[index1-1]) {
				index1++;
				continue;
			}
			// if data1 has smaller element : read next from data1
			if(data1[index1] < data2[index2]) {
				index1++;
			} else if(data1[index1] > data2[index2]) {
				// if data2 has smaller element : read next from data2
				index2++;
			} else {
				// else print common data 
				System.out.print(data1[index1]+" ");
				index1++;
				index2++;
			}
		}
	}
}
