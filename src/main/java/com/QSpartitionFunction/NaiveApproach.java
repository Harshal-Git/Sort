/**
 * 
 */
package com.QSpartitionFunction;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> partition function of a quick sort
 *
 *	-> given an array (unsorted) and an index 'p' (pivot). Find any possible array outcome/s which can be achieved using 'a[p]' 
 *		such that all the elements on left will be smaller OR equal than 'a[p]' and all elements on right are greater than 'a[p]'.
 *
 *	-> ex:
 *		i/p: {3, 8, 6, 12, 10, 7} & p = 5
 *	
 *	 => o/p: {3, 6, 7, 8, 10, 12}
 *		  or {6, 3, 7, 12, 10, 8}
 *		  or...
 *	
 *		i/p: {5, 13, 6, 9, 12, 11, 8} & p = 6
 *
 *	-> Outcome can be anything where the array arrangements will play it's role. Most important requirement is the left & right 
 *		side region of 'a[p]' needs to follow the condition mentioned above.
 *
 *	-> Naive approach : Compared to other solutions, this is stable algo. 
 *
 * -> Time complexity: O(n)+O(n)+O(n) ~ O(n) 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(n)
 * 
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int p;

		int [] data1 = {5, 13, 6, 9, 12, 11, 8};
		p = 6;
		printMessage(data1, p);

		int [] data2 = {3, 8, 6, 12, 10, 7};
		p = 5;
		printMessage(data2, p);
	}

	/**
	 * @param data1
	 * @param p
	 */
	private static void printMessage(int[] data, int p) {
		System.out.println("\nArray: "+Arrays.toString(data)+" and Pivot = "+p);
		findPartition(data, 0, (data.length-1), p);
		System.out.println("Partitioned array: "+Arrays.toString(data));
	}

	/**
	 * find partition 
	 * @param data
	 * @param start
	 * @param end
	 * @param pIndex
	 */
	private static void findPartition(int[] data, int start, int end, int pIndex) {
		int tempSize = ((end-start)+1);
		int [] tempArr = new int[tempSize];
		int tempIndex = 0;

		// iterate over given array and put all elements smaller OR equal to pivot in temp array
		for(int index = start; index <= end; index++) {
			if(data[index] <= data[pIndex]) {
				tempArr[tempIndex] = data[index];
				tempIndex++;
			}
		}
		// iterate over given array and put all elements greater than pivot in temp array
		for(int index = start; index <= end; index++) {
			if(data[index] > data[pIndex]) {
				tempArr[tempIndex] = data[index];
				tempIndex++;
			}
		} 
		// provide data in original array
		for(int index = 0; index < tempSize; index++) {
			data[index] = tempArr[index];
		}
	}
}
