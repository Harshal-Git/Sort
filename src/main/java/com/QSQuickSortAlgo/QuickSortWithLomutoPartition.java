/**
 * 
 */
package com.QSQuickSortAlgo;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Quick sort algo with Lomuto partition
 *
 *	-> algo: 
 *			quickSort(arr[], left, right) {
 *
 *				if(left < right) {
 *				
 *				int pivotIndex = lomutoPartition(arr, left, right);
 *				
 *				quickSort(arr, left, (pivotIndex-1));
 *	
 *				quickSort(arr, (pivotIndex+1), right);
 *
 *				}
 *			}
 *
 *	-> this algo is in-place, cache friendly, has average case as 0(n * log n), tail recursive
 *
 * -> Time complexity:	average case => 0(n * log n) & worst case O(n^2)	
 * -> Space complexity:	O(n) [for array] + O(n) [for call stack] ~ O(n)
 * -> Auxiliary space:	
 * 						for worst case => 0(1) [for Hoare] + O(n) [for call stack] ~ O(n)
 * 						for best case => 0(log n)
 * 
 */
public class QuickSortWithLomutoPartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1= {8, 4, 7, 9, 3, 10, 5};
		printMessage(data1);

		int [] data2= {3, 9, 5, 7, 0, 4, 2};
		printMessage(data2);
	}

	/**
	 * @param data1
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		quickSort(data, 0, (data.length-1));
		System.out.println("Sorted Array: "+Arrays.toString(data));
	}

	/**
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void quickSort(int[] data, int start, int end) {
		if(start < end) {
			// lomuto partition
			int pivotIndex = lomutoPartition(data, start, end);
			// left sort
			quickSort(data, start, (pivotIndex-1));
			// right sort
			quickSort(data, (pivotIndex+1), end);
		}
	}

	/**
	 * @param data
	 * @param start
	 * @param end
	 * @return
	 */
	private static int lomutoPartition(int[] data, int start, int end) {
		// pivot index
		int pivotIndex = end;
		// initial position for sorted window
		int sortPoint = (start-1);
		// iterate over all elements except pivot and for elements smaller 
		// than pivot, shift them towards left sorted window
		for(int index = start; index <= (end-1); index++) {
			// smaller elements than pivot
			if(data[index] < data[pivotIndex]) {
				sortPoint++;
				swap(data, sortPoint, index);
			}
		}
		// at the end, shift pivot to it's correct position
		swap(data, (sortPoint+1), end);
		// return updated index of pivot
		return (sortPoint+1);
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
