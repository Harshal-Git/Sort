/**
 * 
 */
package com.QSQuickSelectOrKthSmallest;

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
 *	-> this is standard solution using Lomuto partition. This will possibly update/sort the array (not when k is (size-1) as that 
 *		will be the pivot for Lomuto partition and in first go; array elements does not get rearranged.)
 *
 * -> Time complexity: O(n * log n) - for sorting using quick sort average case ; O(n^2) in worst case	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:	0(n) - for temp array : not to modify original input [this can be improved]
 */
public class StandardApproach {

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
		int result = findKthSmallestElement(data, k);
		System.out.println("\n"+k+"th smallest element from array: "+Arrays.toString(data)+" is- "+result);
	}

	/**
	 * using Lomuto partition (which sets pivot element at 
	 * correct position & returns the position)
	 * @param data
	 * @param k
	 * @return
	 */
	private static int findKthSmallestElement(int[] data, int k) {
		// initializations
		int start = 0, end = (data.length-1);
		int [] temp = data.clone();

		// iteration
		while(start <= end) {

			// find partition index
			int pIndex = lomutoPartition(temp, start, end);

			// compare pivot element & k
			if(pIndex == (k-1)) {
				return temp[pIndex];
			} else if(pIndex < (k-1)) {
				// if pivot index is lower than given 'k'; perform right partition
				start = (pIndex+1);
			} else {
				// otherwise perform left partition
				end = (pIndex-1);
			}
		}
		// if no Kth smallest element found from given array 
		return -1;
	}

	/**
	 * @param data
	 * @return
	 */
	private static int lomutoPartition(int[] data, int start, int end) {
		// consider pivot as last element
		int pivotIndex = end;
		int leftPtr = (start-1);

		// iterate over all elements
		for(int index = start; index <= (end-1); index++) {
			// for all elements smaller then pivot; move those towards left
			if(data[index] < data[pivotIndex]) {
				leftPtr++;
				swap(data, index, leftPtr);
			}
		}
		// at the end, place pivot at it's correct position
		swap(data, (leftPtr+1), end);
		// return latest pivot index
		return (leftPtr+1);
	}

	/**
	 * 
	 * @param data
	 * @param pos1
	 * @param pos2
	 */
	private static void swap(int[] data, int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
}
