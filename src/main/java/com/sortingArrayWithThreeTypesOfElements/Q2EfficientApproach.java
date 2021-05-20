/**
 * 
 */
package com.sortingArrayWithThreeTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Partition the given element with given pivot point such that all smaller elements should be on left of the pivot 
 *		and higher on right side of the pivot. If multiple occurrences are there for pivot, they all need to be consecutive.
 *
 * 	-> efficient approach : single iteration using Dutch National Flag algo
 * 
 * 	-> ex:
 * 		i/p: {2, 1, 2, 20, 10, 20, 1} & pivot = 2 => o/p: {1, 1, 2, 2, 20, 10, 20}
 * 
 * -> Time complexity: 0(n)	- single traversal
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class Q2EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int pivot;

		int [] data1 = {2, 1, 2, 20, 10, 20, 1};
		pivot = 2;
		printMessage(data1, pivot);
		
		int [] data2 = {2, 3, 5, 4, 7, 6, 1, 4, 9, 8};
		pivot = 4;
		printMessage(data2, pivot);
		
		int [] data3 = {10, 20, 30, 40, 50, 10};
		pivot = 10;
		printMessage(data3, pivot);
	}

	/**
	 * @param data
	 * @param pivot 
	 */
	private static void printMessage(int[] data, int pivot) {
		System.out.println("\nArray: "+Arrays.toString(data)+" -> Pivot: "+pivot);
		partitionArray(data, pivot);
		System.out.println("Partitioned Array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 * @param pivot 
	 */
	private static void partitionArray(int[] data, int pivot) {
		// initialization
		int size = data.length;
		int start = 0, mid = 0, end = (size-1);
		// iterate through all elements until mid & end crosses each other
		while(mid <= end) {
			// if current element smaller than pivot; swap and process left pointers 
			if(data[mid] < pivot) {
				swap(data, start, mid);
				start++;
				mid++;
			} else if(data[mid] == pivot) {
				// if current element is same as pivot; don't swap anything
				mid++;
			} else {
				// if current element is more than pivot; swap & process right pointer only
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
