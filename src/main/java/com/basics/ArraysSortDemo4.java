/**
 * 
 */
package com.basics;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Harshal-Git
 *
 *	-> usage of Arrays.sort() method demo for arrays of primitive classes.
 *
 */
public class ArraysSortDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// for array of primitive classes
		Integer [] intArr = {5, 30, 20, 10, 78};
		System.out.println("Array before sort: "+Arrays.toString(intArr));
		
		// sort by natural order
		Arrays.sort(intArr);
		System.out.println("Array after sort: "+Arrays.toString(intArr));
		
		// sort by descending order (using Comparator of reverse order)
		Arrays.sort(intArr, Collections.reverseOrder());
		System.out.println("Array after reverse sort: "+Arrays.toString(intArr));
	}
}