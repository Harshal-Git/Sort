/**
 * 
 */
package com.selectionSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Efficient approach for reverse selection sort : Unstable algo
 * 
 *	-> For each iteration, keep finding highest element from remaining array elements and once we find such highest element; 
 *		swap it with current index.
 *
 *	-> This process will keep creating window of sorted elements with every iteration on the left side of the array.  
 *	   With every further iteration; this window needs not to be processed. 
 *
 *	-> Instead of finding lowest element, find a max element always and can be replaced with last element.
 *
 * -> Time complexity: 0(n^2)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1) 
 * 
 */
public class HighestElementSortES {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 3, 5, 7, 2, 4, 6};
		printMessage(data1);

		int [] data2 = {10, 8, 6, 4, 2, 0};
		printMessage(data2);

		int [] data3 = {10, 8, 20, 5};
		printMessage(data3);
		
		int [] data4 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		printMessage(data4);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nOriginal array: "+Arrays.toString(data));
		selectionSort(data);
		System.out.println("Reverse sorted array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void selectionSort(int[] data) {
		int size = data.length;
		int highestElementIndex = -1;
		
		// iterate over all element & find highest element index
		for(int index = (size-1); index >= 0; index--) {
			
			// always consider current position for highest element
			highestElementIndex = index;
			
			// iterate over remaining elements on right to find highest element
			for(int count = 0; count < index; count++) {
				if(data[highestElementIndex] < data[count]) {
					highestElementIndex = count;
				}
			}
			// swap current highest element with current elements
			swap(data, index, highestElementIndex);
		}
	}

	/**
	 * @param data
	 * @param lowestIndex
	 * @param index
	 */
	private static void swap(int[] data, int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
}
