/**
 * 
 */
package com.mergeOverlappingIntervals;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 intervals and we need to check whether these intervals overlap each other OR not.
 *	
 *	-> approach : pick the highest start value from both pairs and check whether that start value is already included in the other 
 *				pair? If yes; then pairs overlap each other.
 *
 *				OR
 *				
 *				pick the smallest end value from both pairs and check whether that end value is already included in the other 
 *				pair? If yes; then pairs overlap each other.
 *				
 */
public class CheckOverlapOfIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Pair p1 = null;
		Pair p2 = null;
		
		// case 1
		p1 = new Pair(5, 10);
		p2 = new Pair(1, 7);
		printMessage(p1, p2);
		
		// case 2
		p1 = new Pair(10, 20);
		p2 = new Pair(5, 15);
		printMessage(p1, p2);
		
		// case 3
		p1 = new Pair(10, 20);
		p2 = new Pair(40, 50);
		printMessage(p1, p2);
	}

	/**
	 * @param pair1
	 * @param pair2
	 */
	private static void printMessage(Pair pair1, Pair pair2) {
		boolean isOverlap = isPairsOverlap(pair1, pair2);
		if(isOverlap) {
			System.out.println("\nPairs: "+pair1.toString()+" and "+pair2.toString()+" overlap each other.");
		} else {
			System.out.println("\nPairs: "+pair1.toString()+" and "+pair2.toString()+" don't overlap each other.");
		}
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
