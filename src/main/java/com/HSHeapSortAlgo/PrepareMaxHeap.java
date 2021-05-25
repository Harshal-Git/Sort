/**
 * 
 */
package com.HSHeapSortAlgo;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Max heap : When value of root node is greater OR equal to both of it's children value.
 *
 *	-> For a given unsorted array of natural numbers; prepare a Max Heap. 
 *
 *	-> Root node value starts from 0. Then each upcoming element associated to it's route will be arranged in such a way that
 *		for any element as root at index 'k'; it's left child will be at (2k+1) location and right child will be at (2k+2) location.
 *		
 *	->	For any node at 'k' position, we can find it's parent by (k-1)/2.  
 *
 *	-> Max / Min heap can be considered as a complete binary tree.
 *
 *	ex:
 *	   data = {10, 15, 50, 4, 20};
 *
 *				   10		-> data[0] = 10
 *				  /	 \	
 *				15	 50		-> data[1] = 15 & data[2] = 50
 *			   /  \
 *			  4	  20		-> data[3] = 4 & data[4] = 20
 *		
 *	=> Max heap = {50, 20, 10, 4, 15}
 *	
 *				   50		-> data[0] = 50
 *				  /	 \	
 *				20	 10		-> data[1] = 20 & data[2] = 10
 *			   /  \
 *			  4	  15		-> data[3] = 4 & data[4] = 15
 *
 * -> Time complexity: 	O(n)
 * -> Space complexity:	O(log n) - [recursion call stack]
 * -> Auxiliary space:  O(log n) - [recursion call stack]
 */
public class PrepareMaxHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 15, 50, 4, 20};
		printMessage(data1);

		int [] data2 = {10, 15, 50, 4, 20, 6, 3};
		printMessage(data2);
		
		int [] data3 = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
		printMessage(data3);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data));
		buildMaxHeap(data);
		System.out.println("Max heap: "+Arrays.toString(data));
	}

	/**
	 * @param data
	 * 
	 * note: this loop starts with the parent node of last element and goes till the first element. 
	 * For an array of 'n' size, Last element will be (n-1) & it's parent node will be ((n-1)-1)/2) = (n-2)/2
	 */
	private static void buildMaxHeap(int[] data) {
		int size = data.length;
		for(int index = ((size-2)/2); index >= 0; index--) {
			maxHeapify(data, size, index);
		}
	}

	/**
	 * @param data
	 * @param index
	 * @param index2 
	 */
	private static void maxHeapify(int[] data, int size, int index) {
		// initializations
		int largest = index;
		int left = ((2*index)+1), right = ((2*index)+2);

		if(left < size && (data[left] > data[largest])) {
			largest = left;
		} 
		if(right < size && (data[right] > data[largest])) {
			largest = right;
		}
		if(largest != index) {
			swap(data, largest, index);
			maxHeapify(data, size, largest);
		}
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
