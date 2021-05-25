/**
 * 
 */
package com.mergeOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Harshal-Git
 *
 *	-> Given array of pairs which has start & end elements of intervals. We need to merge such intervals.
 *
 *	-> ex:
 *			i/p: {{1, 3},{2, 4},{5, 7},{6, 8}}	=> o/p: {1, 4},{5, 8}
 *
 *			i/p: {{7, 9},{6, 10},{4, 5},{1, 3},{2, 4}}	=> o/p: {1, 5},{6, 10}
 *
 *			i/p: {{5, 10},{2, 3},{6, 8},{1, 7}}	=> o/p: {1, 10}
 *	
 * -> Time complexity:  [0(n * log n) - for sorting] + [0(n) - for merging] + [O(n) - for printing] ~ 0(n * log n)  
 * -> Space complexity: 0(n)
 * -> Auxiliary space: O(n) - additional space may be used in sorting
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		Pair [] pairs1 = {new Pair(1, 3), new Pair(2, 4), new Pair(5, 7), new Pair(6, 8)};
		printMergedIntervals(pairs1);

		// case 2
		Pair [] pairs2 = {new Pair(7, 9), new Pair(6, 10), new Pair(4, 5), new Pair(1, 3), new Pair(2, 4)};
		printMergedIntervals(pairs2);

		// case 3
		Pair [] pairs3 = {new Pair(5, 10), new Pair(2, 3), new Pair(6, 8), new Pair(1, 7)};
		printMergedIntervals(pairs3);

		// case 4
		Pair [] pairs4 = {new Pair(5, 10), new Pair(3, 15), new Pair(18, 30), new Pair(2, 7)};
		printMergedIntervals(pairs4);
	}

	/**
	 * @param pairs
	 */
	private static void printMergedIntervals(Pair[] pairs) {
		System.out.print("\nIntervals: "+Arrays.deepToString(pairs)+"\nMerged intervals: ");
		getIntervalsMerged(pairs);
		System.out.println();
	}

	/**
	 * @param pairs
	 */
	private static void getIntervalsMerged(Pair[] pairs) {
		// first sort the given intervals
		Arrays.sort(pairs, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return (p1.getStart() - p2.getStart());
			}
		});

		// now iterate over sorted intervals and keep merging valid intervals
		int lastMergedInterval = 0; // take default first interval as merged
		Pair lastMerged = null, current = null;
		int minStart = -1, maxEnd = -1;

		// iterate over remaining elements
		for(int index = 1; index < pairs.length; index++) {

			lastMerged = pairs[lastMergedInterval];
			current = pairs[index];

			// if pairs are overlapping?
			if(lastMerged.getEnd() >= current.getStart()) {
				minStart = findMinStart(lastMerged, current);
				maxEnd = findMaxEnd(lastMerged, current);
				lastMerged = new Pair(minStart, maxEnd);
				pairs[lastMergedInterval] = lastMerged;
			} else {
				/*
				 * if current pair is not overlapping with any interval, increment the last 
				 * merged interval index and replace it with current interval as a whole
				 * as elements except last merged intervals are of no use 
				 */
				lastMergedInterval++;
				pairs[lastMergedInterval] = pairs[index];
			}
		}
		// iterate over elements till the last merged index
		for(int index = 0; index <= lastMergedInterval; index++) {
			System.out.print(pairs[index].toString()+" ");
		}
	}

	/**
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static int findMaxEnd(Pair p1, Pair p2) {
		return ((p1.getEnd() < p2.getEnd()) ? (p2.getEnd()) : (p1.getEnd()));
	}

	/**
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static int findMinStart(Pair p1, Pair p2) {
		return ((p1.getStart() < p2.getStart()) ? (p1.getStart()) : (p2.getStart()));
	}
}
