/**
 * 
 */
package com.QSpartitionFunction;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> This approach is called Lomuto partition. In this algo, pivot 'p' is considered as the last element always.
 *
 *	-> If in any case we are given custom pivot 'p' and still needs to apply Lomuto partition, we can swap last element 
 *		with 'p' and then can follow the standard Lomuto algo.
 *
 *	-> This algo will maintain lower & higher elements window virtually. Initially lower window will not exist and higher window 
 *		will be the whole array itself. 
 * 
 *	->	Keep iterating all elements until the higher window shrinks to pivot element. For any element smaller than pivot, 
 *		first increment lower window size & put it into the lower window last position. At the same time, reduce higher window. 
 *		At the last; pivot element will be put at it's correct position; which will separate lower & higher elements window. 
 *
 *	-> ex:
 *		i/p: {10, 80, 30, 90, 40, 50, 70}
 *	
 *		i/p: {70, 60, 80, 40, 30}
 *
 *		i/p: {30, 40, 20, 50, 80}
 *
 * -> Time complexity: O(n) 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 * 
 */
public class LomutoPartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {5, 3, 8, 4, 2, 7, 1, 10};
		printMessage(data1);

		int [] data2 = {3, 8, 6, 12, 10, 7};
		printMessage(data2);

		int [] data3 = {10, 80, 30, 90, 40, 50, 70};
		printMessage(data3);

		int [] data4 = {70, 60, 80, 40, 30};
		printMessage(data4);

		int [] data5 = {30, 40, 20, 50, 80};
		printMessage(data5);

		int [] data6 = {5, 10, 9, 12};
		printMessage(data6);

		int [] data7 = {12, 10, 9, 5};
		printMessage(data7);

		int [] data8 = {5, 5, 5, 5};
		printMessage(data8);
	}

	/**
	 * @param data
	 * @param p
	 */
	private static void printMessage(int[] data) {
		System.out.println("\nArray: "+Arrays.toString(data)+" => Pivot: "+(data.length-1));
		int newPivot = lomutoPartition(data, 0, (data.length-1));
		System.out.println("Partitioned array: "+Arrays.toString(data)+" => New Pivot position: "+newPivot);
	}

	/**
	 * find partition 
	 * @param data
	 * @param start
	 * @param end
	 * @param pIndex
	 */
	private static int lomutoPartition(int[] data, int start, int end) {
		/*
		 * in this algo, PIVOT IS ALWAYS CONSIDERED AS LAST ELEMENT.
		 * So if any time a custom pivot is given, first swap custom pivot 
		 * with last element and then choose pivot as the last element and
		 * continue following the Lomuto partition. 
		 * 
		 * Here pivot index can be taken (compared to Hoare's partition) 
		 * because this index is used at the last when complete remaining
		 * array is partitioned. 
		 */
		int pIndex = end;
		int leftPos = (start-1);

		/*
		 * iterate through elements and maintain left side of
		 * the array with smaller OR equal elements than pivot
		 * the index here represents the higher window itself. 
		 */
		for(int index = start; index <= (end-1);  index++) {
			/*
			 * if any element is smaller than pivot; increase lower
			 * window size and put the element at last position 
			 */
			if(data[index] < data[pIndex]) {
				leftPos++;
				swap(data, leftPos, index);
			}
		}
		// at the end, move pivot to it's correct position
		swap(data, (leftPos+1), pIndex);
		// this method can return position of updated pivot
		return (leftPos+1);
	}

	/**
	 * @param data
	 * @param leftPos
	 * @param index
	 */
	private static void swap(int[] data, int pos1, int pos2) {
		//System.out.println("swap("+pos1+","+pos2+")");
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
}
