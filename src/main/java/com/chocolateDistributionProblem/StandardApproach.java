/**
 * 
 */
package com.chocolateDistributionProblem;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Chocolate distribution problem : see the video for explanation
 *
 *	-> Goal is to minimize difference for minimum & maximum number of chocolates (arr) distributed among given 
 *		number of kids (m).
 *
 * 	-> ex:
 * 			i/p: {7, 3, 2, 4, 9, 12, 56} & m = 3	=> o/p: 2 (we can give 3 / 2 / 4 chocolates to 3 children for which the 
 * 																difference between max & min number of chocolates is 2)
 * 														[For any other set of numbers, the difference between min & max number 
 * 														of chocolates is greater than 2.]
 * 
 * 			i/p: {3, 4, 1, 9, 56, 7, 9, 12} & m = 5	=> o/p: 6 (give 3 / 4 / 7 / 9 / 9 chocolates to 5 kids and the difference
 * 																between 9 (max) & 3 (min) will be 6)  
 *  	
 * -> Time complexity: 0(n * log n)	[for sorting] + 0(n) ~ 0(n * log n) 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:	0(1)
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int m;

		int [] data1 = {7, 3, 2, 4, 9, 12, 56};
		m = 3;
		printMessage(data1, m);

		int [] data2 = {3, 4, 1, 9, 56, 7, 9, 12};
		m = 5;
		printMessage(data2, m);

	}

	/**
	 * @param data
	 * @param m
	 */
	private static void printMessage(int[] data, int m) {
		// validation
		if(m > data.length) {
			throw new IllegalArgumentException("Invalid inputs.");
		}
		System.out.println("\nOut of "+Arrays.toString(data)+" chocolates among "+m
				+" children, minimum difference can be found as: "+findMinDifference(data, m));
	}

	/**
	 * @param data
	 * @param m
	 * @return
	 */
	private static int findMinDifference(int[] data, int m) {

		// first sort the given array
		Arrays.sort(data);

		// initialization
		int minDiff = ((data[m-1])-(data[0]));
		int size = data.length;

		/*
		 * for each element as lowest element and find the M-th element from that position;
		 * and find the difference.  For all elements, find such lowest difference.
		 */
		for(int index = 1; index <= (size-m);index++) {
			minDiff = findMin(minDiff, (data[index+m-1]-data[index]));
		}
		// return the minimum difference
		return minDiff;
	}

	/**
	 * @param minDiff
	 * @param i
	 * @return
	 */
	private static int findMin(int num1, int num2) {
		return ((num1 < num2) ? (num1) : (num2));
	}
}
