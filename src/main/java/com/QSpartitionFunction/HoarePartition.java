/**
 * 
 */
package com.QSpartitionFunction;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> This approach is called Hoare partition. For this by default, pivot is considered as first element. 
 *
 *	-> This approach maintains 2 pointers which are initially set to extreme positions (left & right). Using do-while loop, they
 *		both are approached towards each other and meanwhile left pointer stops if any element is found to be greater than pivot &
 *		right pointer stops if any element is found smaller than pivot. When that happens, those elements are supposed to be swapped. 
 *
 *	-> Once they cross each other, the position of right pointer is the pivot position from which all lower elements from pivot 
 *		will be on left side & higher will be on right side.  
 *
 *	-> This algo might not always place pivot element at correct position as it happens in Lomuto partition. 
 *
 *	-> ex:
 *		i/p: {5, 3, 8, 4, 2, 7, 1, 10}
 *
 *		i/p: {5, 10, 9, 12}
 *
 *		i/p: {12, 10, 9, 5}
 *
 *		i/p: {5, 5, 5, 5}
 *	
 * -> Time complexity: O(n) 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 * 
 */
public class HoarePartition {

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
		System.out.println("\nArray: "+Arrays.toString(data)+" => Pivot element: "+(data[0]));
		int newPivot = hoarePartition(data, 0, (data.length-1));
		System.out.println("Partitioned array: "+Arrays.toString(data)+" => New Pivot position: "+newPivot);
	}

	/**
	 * find partition 
	 * @param data
	 * @param start
	 * @param end
	 * @param pIndex
	 */
	private static int hoarePartition(int[] data, int start, int end) {

		// initialize pivot element as first position
		// don't take index here otherwise it will 
		// always consider new pivot for all iterations
		int pivot = data[0];

		// pointers left & right
		int leftPos = (start-1), rightPos = (end+1);

		// traverse through all elements
		while(true) {

			// check for any element higher than pivot on left side; if yes then stop
			do{
				leftPos++;
			}while(data[leftPos] < pivot);	

			// check for any element lower than pivot on right side; if yes then stop
			do{
				rightPos--;
			}while(data[rightPos] > pivot);

			// if they have crossed each other; return right 
			// pointer which differentiates the array partition
			if(leftPos >= rightPos) {
				return rightPos;
			}
			// swap the elements 
			swap(data, leftPos, rightPos);
		}
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
