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
 *	-> efficient solution 
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
 * 
 * -> Time complexity: O(n * log n) + 0(n) ~ O(n * log n)  	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class EfficientApproach {

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
	 * @param data1
	 * @return
	 */
	private static int findMinDiff(int[] data) {

		// initializations
		int size = data.length;

		// MAX_VALUE as default lowest difference 
		int minDiff = Integer.MAX_VALUE;

		// sort the given array
		Arrays.sort(data);

		// now for each element; find lowest consecutive elements difference.
		for(int index = 0; index < (size-1); index++) {
			minDiff = findMin(minDiff, Math.abs(data[index+1] - data[index]));
		}
		// return the lowest difference
		return minDiff;
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
