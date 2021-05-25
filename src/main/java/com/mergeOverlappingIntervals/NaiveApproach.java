/**
 * 
 */
package com.mergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.List;

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
 * -> Time complexity: [O(n*n) - for while loop and start counter reset] * [O(n) - for removal operation] ~ O(n^3) 	
 * -> Space complexity:	O(n) - for list storage
 * -> Auxiliary space: O(1) - no additional storage is used
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Pair> pairs = new ArrayList<>();

		// case 1
		pairs.add(new Pair(1, 3));pairs.add(new Pair(2, 4));pairs.add(new Pair(5, 7));pairs.add(new Pair(6, 8));
		printMergedIntervals(pairs);

		// case 2
		pairs.clear();
		pairs.add(new Pair(7, 9));pairs.add(new Pair(6, 10));pairs.add(new Pair(4, 5));pairs.add(new Pair(1, 3));
		pairs.add(new Pair(2, 4));
		printMergedIntervals(pairs);
		
		// case 3
		pairs.clear();
		pairs.add(new Pair(5, 10));pairs.add(new Pair(2, 3));pairs.add(new Pair(1, 7));pairs.add(new Pair(6, 8));
		printMergedIntervals(pairs);
		
		// case 4
		pairs.clear();
		pairs.add(new Pair(5, 10));pairs.add(new Pair(3, 15));pairs.add(new Pair(18, 30));pairs.add(new Pair(2, 7));
		printMergedIntervals(pairs);
	}

	/**
	 * @param pairs
	 */
	private static void printMergedIntervals(List<Pair> pairs) {
		System.out.println("\nIntervals: "+pairs.toString());
		getIntervalsMerged(pairs);
	}

	/**
	 * @param pairs
	 */
	private static void getIntervalsMerged(List<Pair> pairs) {
		// initializations
		int start = 0;
		Pair p1 = null, p2 = null;
		int minStart = -1, maxEnd = -1;

		// iterate over all elements and find pairs which are eligible for merge
		while(start <= pairs.size()) {

			// for each element; find a pair which can be merged
			for(int index = (start+1); index < pairs.size(); index++) {

				// get pairs
				p1 = pairs.get(start);
				p2 = pairs.get(index);
				
				// does the pair overlap?
				if(isPairsOverlap(p1, p2)) {
					// remove both pairs 
					pairs.remove(p1);
					pairs.remove(p2);
					// insert merged pair at first pair location
					minStart = findMinStart(p1, p2);
					maxEnd = findMaxEnd(p1, p2);
					p1 = new Pair(minStart, maxEnd);
					pairs.add(start, p1);
					// once merge happens; reset start counter and start afresh
					start = -1;
					break;
				}
			}
			// if no merge happens; keep incrementing start counter
			start++;
		}
		// print all merged intervals
		System.out.println("Merged intervals: "+pairs.toString());
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

	/**
	 * @param pair1
	 * @param pair2
	 * @return
	 */
	private static boolean isPairsOverlap(Pair pair1, Pair pair2) {

		// find pair with highest start point
		int highestStartPoint = ((pair1.getStart() > pair2.getStart()) ? (pair1.getStart()) : (pair2.getStart()));

		// find the pair which will be checked for inclusion of highest start point
		Pair pairToBeChecked = ((pair1.getStart() > pair2.getStart()) ? (pair2) : (pair1));

		// check whether highest start point is included in other pair?
		if((highestStartPoint >= pairToBeChecked.getStart()) &&  (highestStartPoint <= pairToBeChecked.getEnd())) {
			return true;
		}
		// for all other options: if intervals don't overlap each other
		return false;
	}

}
