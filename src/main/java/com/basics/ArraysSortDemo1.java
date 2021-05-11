/**
 * 
 */
package com.basics;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> usage of Arrays.sort() method demo
 *
 *	-> This sorting is based on dual pivot quick sort; which is applicable only for primitive element array.
 *
 *	-> It provides only natural order during sorting. We cannot provide any custom sorting mechanism to it.
 *
 *	-> This sort doesn't provide sorting stability.
 *
 *	-> For array of custom class; by default sort() relies on compareTo() method provided by java.lang.Comparable<I> interface. 
 *		If no such provision is given, then this method takes java.util.Comparator<I> argument also. And then sorting happens 
 *		with Legacy merge sort.
 *
 */
public class ArraysSortDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Sort full array
		int [] data1 = {5, 30, 20, 10, 78};
		System.out.println("\nArray 1 before sort: "+Arrays.toString(data1));
		Arrays.sort(data1);
		System.out.println("Array 1 after sort: "+Arrays.toString(data1));

		// Sort partial array
		int [] data2 = {5, 30, 20, 10, 78, 33, 41, 33, 6, 8};
		System.out.println("\nArray 2 before sort: "+Arrays.toString(data2));
		// including 3 & excluding 8
		Arrays.sort(data2, 3, 8);	
		System.out.println("Array 2 after sort(3, 8): "+Arrays.toString(data2));

		// including 0 & excluding 5
		Arrays.sort(data2, 0, 5);	
		System.out.println("Array 2 after sort(0, 5): "+Arrays.toString(data2));
	}
}