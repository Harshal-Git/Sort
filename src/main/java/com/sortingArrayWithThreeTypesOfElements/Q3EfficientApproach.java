/**
 * 
 */
package com.sortingArrayWithThreeTypesOfElements;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Partition the given array around a given range in such a way that all elements from given range's smallest element comes
 *		on left & other elements comes on right. Range has 2 point {a, b} where a <= b.
 *
 * 	-> efficient approach : single iteration using Dutch National Flag algo
 * 
 * 	-> ex:
 * 		i/p: {10, 5, 6, 3, 20, 9, 40} & range = [5, 10]	=> o/p: {3, 5, 6, 9, 10, 20, 40} 
 * 
 * -> Time complexity: 0(n)	- single traversal
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class Q3EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 5, 6, 3, 20, 9, 40};
		int [] range1 = {5, 10};
		printMessage(data1, range1);

		int [] data2 = {2, 3, 5, 7, 6, 1, 4, 9, 8};
		int [] range2 = {3, 6};
		printMessage(data2, range2);
	}

	/**
	 * @param data
	 * @param pivot 
	 */
	private static void printMessage(int[] data, int[] range) {
		System.out.println("\nArray: "+Arrays.toString(data)+" -> Pivot: "+Arrays.toString(range));
		partitionArray(data, range);
		System.out.println("Partitioned Array: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 * @param range 
	 */
	private static void partitionArray(int[] data, int[] range) {
		// initialization
		int size = data.length;
		int start = 0, mid = 0, end = (size-1);
		// iterate through all elements until mid & end crosses each other
		while(mid <= end) {
			// if current element smaller than pivot; swap and process left pointers 
			if(data[mid] < range[0]) {
				swap(data, start, mid);
				start++;
				mid++;
			} else if((data[mid] >= range[0]) && (data[mid] <= range[1])) {
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
