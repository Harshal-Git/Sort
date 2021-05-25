/**
 * 
 */
package com.HSHeapSortAlgo;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Sorting a given array with Heap sort.
 *
 * -> Time complexity: O(n * log n)	
 * -> Space complexity:	??
 * -> Auxiliary space:	??
 */
public class HeapSortWithMaxHeap {

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
		heapSortWithMaxHeap(data);
		System.out.println("Sorted array: "+Arrays.toString(data));
	}

	/**
	 * @param data - sort given array with max heap
	 */
	private static void heapSortWithMaxHeap(int[] data) {

		int size = data.length;

		// first build max heap for given array
		buildMaxHeap(data);
		//System.out.println("Max heap: "+Arrays.toString(data));

		// then for each element, find max element and swap 
		// it with last element and keep reducing the heap size 
		for(int index = (size-1); index >= 1; index--) {
			swap(data, 0, index);
			maxHeapify(data, index, 0);
			//System.out.println("Updated Max heap for iteration "+index+" => "+Arrays.toString(data));
		}
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
