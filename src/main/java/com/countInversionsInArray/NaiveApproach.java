/**
 * 
 */
package com.countInversionsInArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Count number of inversions in a given array. Inversion is considered if a pair from given array, (a[i], a[j]) is formed such
 *		that i < j AND a[i] > a[j].
 *
 *	-> naive approach : double iteration of given loop
 *
 *	-> ex:
 *		  i/p: {2, 4, 1, 3, 5} => o/p: 3 [(4, 1), (4, 3), (2, 1)]
 *
 *		  i/p: {10, 20, 30, 40} => o/p: 0 [no such inversion pairs can be made with an ascending sorted array]
 *
 *		  i/p: {40, 30, 20, 10} => o/p: 6 [(40, 30), (40, 20), (40, 10), (30, 20), (30, 10), (20, 10)]
 *
 * -> Time complexity:	O(n^2)
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {2, 4, 1, 3, 5};
		System.out.println("Array: "+Arrays.toString(data1)+": inversions => "+getInversions(data1));
		
		int [] data2 = {10, 20, 30, 40};
		System.out.println("\nArray: "+Arrays.toString(data2)+": inversions => "+getInversions(data2));
		
		int [] data3 = {40, 30, 20, 10};
		System.out.println("\nArray: "+Arrays.toString(data3)+": inversions => "+getInversions(data3));
		
		int [] data4 = {2, 5, 8, 11, 3, 6, 9, 13};
		System.out.println("\nArray: "+Arrays.toString(data4)+": inversions => "+getInversions(data4));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int getInversions(int[] data) {
		int size = data.length;
		int inversionCount = 0;
		// iterate over all elements
		for(int index = 0; index < (size-1); index++) {
			// for each element, find inversion pair
			for(int count = (index+1); count < size; count++) {
				if(data[index] > data[count]) {
					inversionCount++;
				}
			}
		}
		return inversionCount;
	}

}
