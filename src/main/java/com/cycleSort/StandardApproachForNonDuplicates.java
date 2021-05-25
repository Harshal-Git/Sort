/**
 * 
 */
package com.cycleSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Sort given array with Cycle sort.
 *
 *	-> This algo performs lowest swaps / memory writes for the elements. It's in-place but not stable.
 *
 *	-> Variation: Find minimum swaps needed to sort given array.
 *
 * -> Time complexity: O(n^2)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space:  0(1)
 */
public class StandardApproachForNonDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1= {5, 12, 4, 6, 8};
		printMessage(data1);

		int [] data2= {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		printMessage(data2);
	}

	/**
	 * @param data1
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		cycleSortDistinct(data);
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void cycleSortDistinct(int[] data) {
		int size = data.length;
		int sortKey = -1;
		int sortKeyIndex = -1;
		int noOfSwaps = 0;	// a variation can be asked to find number of swaps
		
		// iterate over each element and find number of lower elements than current element
		for(int cycleStart = 0; cycleStart < size; cycleStart++) {

			// initializations for a sort key
			sortKey = data[cycleStart];
			sortKeyIndex = cycleStart;

			// count lower elements than current element
			for(int lowIndex = (cycleStart+1); lowIndex < size; lowIndex++) {
				if(data[lowIndex] < sortKey) {
					sortKeyIndex++;
				}
			}
			// swap current element with those many positions
			sortKey = updateSortKey(data, sortKey, sortKeyIndex);
			noOfSwaps++;
			//System.out.println("-> sort key = "+sortKey+" : "+Arrays.toString(data));
			
			// repeat the cycle until we reach to the same element from  
			// where cycle is started and perform the same process as above
			while(sortKeyIndex != cycleStart) {
				sortKeyIndex = cycleStart;
				for(int lowIndex = (cycleStart+1); lowIndex < size; lowIndex++) {
					if(data[lowIndex] < sortKey) {
						sortKeyIndex++;
					}
				}
				// swap current element with those many positions
				sortKey = updateSortKey(data, sortKey, sortKeyIndex);
				noOfSwaps++;
				//System.out.println("-> sort key = "+sortKey+" : "+Arrays.toString(data));
			}
		}
		// print number of swaps
		//System.out.println("Total swaps: "+noOfSwaps);
	}

	/**
	 * @param data
	 * @param sortKey
	 * @param sortKeyIndex
	 * @return
	 */
	private static int updateSortKey(int[] data, int sortKey, int sortKeyIndex) {
		int temp = data[sortKeyIndex];
		data[sortKeyIndex] = sortKey;
		return temp;
	}
}
