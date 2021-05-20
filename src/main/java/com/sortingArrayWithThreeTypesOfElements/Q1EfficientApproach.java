/**
 * 
 */
package com.sortingArrayWithThreeTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Sort the given array of 0s, 1s, & 2s as such that 0s comes first, then 1s and then 2s.
 *
 * 	-> efficient approach : single iteration using Dutch National Flag algo
 * 
 * 	-> algo: maintaining 3 pointers (start, mid, end) based on which there will be 4 virtual partitions of the array.
 * 
 *  	1. from 0 -> start : all the 0 elements
 *  	2. from start -> mid : all the 1 elements
 *  	3. from mid -> end : all the 2 elements
 *  	4. Unknown portion 	
 *   
 *   Initially, start & mid will be at 0 position & end will be at last position. In-between complete array will be an unknown 
 *   portion. As elements are traversed, only mid & end will be used for all elements comparison and once any element is checked 
 *   to be a candidate in either of the group 1/2/3; it's swapped with mid. Once 'mid' & 'end' crosses each other; iteration stops.
 *   
 *   As in any group element is filled, it's swapped with currently traversing element.  
 * 
 * 	-> ex:
 * 		i/p: {0, 1, 0, 2, 1, 2}	=> o/p: {0, 0, 1, 1, 2, 2}
 * 
 * -> Time complexity: 0(n)	- single traversal
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class Q1EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 1, 0, 2, 1, 2, 1, 2, 2};
		printMessage(data1);

		int [] data2 = {0, 1, 0, 2, 1, 0, 2, 0, 2, 1};
		printMessage(data2);
		
		int [] data3 = {0, 1, 0, 1, 0, 0, 2, 1};
		printMessage(data3);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		partitionArray(data);
		System.out.println("Partitioned Array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 */
	private static void partitionArray(int[] data) {
		// initialization
		int size = data.length;
		int start = 0, mid = 0, end = (size-1);
		// iterate through all elements until mid & end crosses each other
		while(mid <= end) {
			// if current element '0'; swap and process left pointers 
			if(data[mid] == 0) {
				swap(data, start, mid);
				start++;
				mid++;
			} else if(data[mid] == 1) {
				// if current element is '1'; don't swap anything
				mid++;
			} else {
				// if current element is '2'; swap & process right pointer only
				swap(data, mid, end);
				end--;
			}
		}
	}

	/**
	 * @param data
	 * @param start
	 * @param mid
	 */
	private static void swap(int[] data, int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}

}
