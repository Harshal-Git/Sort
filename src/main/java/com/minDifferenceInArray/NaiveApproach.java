/**
 * 
 */
package com.minDifferenceInArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find minimum difference between elements of a given array with natural number - sorted OR unsorted.
 *
 *	-> naive solution : compare each element with each other using 2 loops.
 *
 * 	-> ex:
 * 			i/p: {1, 8, 12, 5, 18}	=> o/p: 3 (8-5)
 * 
 * 			i/p: {8, 15}	=> o/p: 7 (8-15) [TO HANDLE NEGATIVE VALUES PROPERLY, FIND ABSOLUTE VALUES]
 * 
 * 			i/p: {8, -1, 0, 3}	=> o/p: 1 (-1-0)
 * 
 * 			i/p: {10}	=> o/p: Integer.MAX_VAL
 * 
 * -> Time complexity: 0(n^2)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 * 
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 8, 12, 5, 18};
		System.out.println("Array: "+Arrays.toString(data1)+" => Min difference: "+findMinDiff(data1));

		int [] data2 = {8, 15};
		System.out.println("\nArray: "+Arrays.toString(data2)+" => Min difference: "+findMinDiff(data2));
		
		int [] data3 = {8, -1, 0, 3};
		System.out.println("\nArray: "+Arrays.toString(data3)+" => Min difference: "+findMinDiff(data3));
		
		int [] data4 = {10};
		System.out.println("\nArray: "+Arrays.toString(data4)+" => Min difference: "+findMinDiff(data4));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findMinDiff(int[] data) {
		// initializations
		int size = data.length;
		int diff = Integer.MAX_VALUE;

		// iterate over all elements
		for(int index = 1; index < size; index++) {
			// iterate over all previous element of current element
			for(int sub = 0; sub < index; sub++) {
				// find lowest difference of all previous element of current element
				diff = findMin(diff, Math.abs(data[index]-data[sub]));
			}
		}
		return diff;
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static int findMin(int num1, int num2) {
		return ((num1 < num2) ? (num1) : (num2));
	}

}
