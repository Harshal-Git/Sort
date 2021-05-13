/**
 * 
 */
package com.MSmergeSortedArrays;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> merge 2 sorted arrays in sorted manner.
 *
 * -> Time complexity: O(m) + O(n) = O(m+n)	
 * -> Space complexity:	0(m) + 0(n) = 0(m+n)
 * -> Auxiliary space: 0(m+n)
 * 
 * -> Instead of using a third array for storing & printing again; if we directly print the elements;
 * 		the auxiliary space can be constant.  
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 20, 30, 40, 50};
		int [] data2 = {5, 15, 25, 35, 45};
		int [] data3 = {1, 2, 3, 4};
		int [] data4 = {1, 3, 5, 7, 9};
		int [] data5 = {2, 4, 6, 8, 10};

		printMessage(data1, data2);
		printMessage(data1, data3);
		printMessage(data1, data4);
		printMessage(data1, data5);
		printMessage(data2, data3);
		printMessage(data2, data4);
		printMessage(data2, data5);
		printMessage(data3, data4);
	}

	/**
	 * @param data1
	 * @param data2
	 */
	private static void printMessage(int[] data1, int[] data2) {
		System.out.println("\nArray 1: "+Arrays.toString(data1));
		System.out.println("Array 2: "+Arrays.toString(data2));
		System.out.println("Merged array: "+Arrays.toString(mergeArray(data1, data2)));		
	}

	/**
	 * @param data1
	 * @param data2
	 * @return
	 */
	private static int[] mergeArray(int[] data1, int[] data2) {

		int size1 = data1.length;
		int size2 = data2.length;

		// combined array
		int [] mergedArray = new int[size1+size2];
		
		// initializations
		int index1 = 0;
		int index2 = 0; 
		int mergeIndex = 0;

		// iterate till the merged array is filled 
		while(mergeIndex < (size1+size2)) {
			// if both arrays are of same length
			if((index1 < size1) && (index2 < size2)) {
				// check for lower elements from respective 
				// arrays and copy into merged array
				if(data1[index1] <= data2[index2]) {
					mergedArray[mergeIndex] = data1[index1];
					index1++;
				} else {
					mergedArray[mergeIndex] = data2[index2];
					index2++;
				} 
			} else if(index1 < size1) {
				// if array2 is exhausted
				mergedArray[mergeIndex] = data1[index1];
				index1++;
			} else {
				// if array1 is exhausted
				mergedArray[mergeIndex] = data2[index2];
				index2++;
			}
			// keep incrementing combined array index
			mergeIndex++;
		}
		// return merged array
		return mergedArray;
	}
}
