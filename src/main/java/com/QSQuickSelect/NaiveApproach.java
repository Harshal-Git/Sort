/**
 * 
 */
package com.QSQuickSelect;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Given an array of natural numbers (all elements present uniquely). We need to find kth smallest element from given array.
 *		k >= 0. This process is known as Quick select.
 *
 *	-> ex:
 *			i/p: {10, 5, 30, 12} & k = 2	=> o/p: 10
 *
 *			i/p: {30, 20, 5, 10, 8} & k = 4	=> o/p: 20
 *	
 *	-> this is naive solution : first sort the array & then return element from (k-1) position.
 *								[TRY NOT TO MODIFY ORIGINAL ARRAY]
 *
 * -> Time complexity: O(n * log n) - for sorting using quick sort average case	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:	0(n) - DS used by Arrays.sort()
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int k;

		int [] data1 = {10, 5, 30, 12};
		k = 2;
		printMessage(data1, k);
		
		int [] data2 = {30, 20, 5, 10, 8};
		k = 4;
		printMessage(data2, k);

		int [] data3 = {10, 4, 5, 8, 11, 6, 26};
		k = 5;
		printMessage(data3, k);
	}

	/**
	 * @param data
	 * @param k
	 */
	private static void printMessage(int[] data, int k) {
		// validation
		if(k > data.length || k <= 0) {
			throw new IllegalArgumentException("Invalid input k = "+k);
		}
		// find smallest element index
		int [] temp = data.clone();
		int resultIndex = findKthSmallestElementIndex(temp, k);
		if(resultIndex > 0) {
			System.out.println("\n"+k+"th smallest element from array: "+Arrays.toString(data)+" is: "+data[resultIndex]);
		} else {
			System.out.println("No "+k+"th smallest element found from array: "+Arrays.toString(data));
		}
	}

	/**
	 * @param data
	 * @param k
	 * @return
	 */
	private static int findKthSmallestElementIndex(int[] data, int k) {
		// sort given array (quick sort for primitive)
		Arrays.sort(data);
		// return (k-1) index
		return (k-1);
	}
}
