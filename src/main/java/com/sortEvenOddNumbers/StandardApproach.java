/**
 * 
 */
package com.sortEvenOddNumbers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Harshal-Git
 *
 *	-> From given integer array; sort even & odd numbers such that even numbers comes first and then odd numbers. 
 *
 *	-> This sort will maintain the order in which even OR odd are appearing independently. It will not sort those
 *		numbers again; as this sorting doesn't guarantee stability.
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer [] data1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Array: "+Arrays.toString(data1));
		printSortedArray(data1);

		Integer [] data2 = {10, 15, 20, 25, 30};
		System.out.println("\nArray: "+Arrays.toString(data2));
		printSortedArray(data2);

		Integer [] data3 = {29, 11, 17, 23, 29, 13};
		System.out.println("\nArray: "+Arrays.toString(data3));
		printSortedArray(data3);

		Integer [] data4 = {4, 5, 6, 1, 2, 3};
		System.out.println("\nArray: "+Arrays.toString(data4));
		printSortedArray(data4);
	}

	/**
	 * @param data1
	 */
	private static void printSortedArray(Integer[] data) {
		// sort array
		Arrays.sort(data, new Comparator<Integer>() {
			@Override
			public int compare(Integer int1, Integer int2) {
				return ((int1.intValue()%2) - (int2.intValue()%2));
			}
		});
		// print sorted array
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

}
