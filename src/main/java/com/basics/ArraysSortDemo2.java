/**
 * 
 */
package com.basics;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> usage of Arrays.sort() method demo
 *
 *	-> For array of custom class; by default sort() relies on compareTo() method provided by java.lang.Comparable<I> interface. 
 *		If no such provision is given, then this method takes java.util.Comparator<I> argument also. And then sorting happens 
 *		with Legacy merge sort.
 */
public class ArraysSortDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// sort method for custom class
		Point1 [] pointsArr = {new Point1(3, 12), new Point1(5, 17), new Point1(-3, 8), new Point1(10, 0), new Point1(6, -2)};

		System.out.println("\nPoint array before sort: "+Arrays.toString(pointsArr));

		// sort this given array by Y point value : ascending order
		Arrays.sort(pointsArr);

		// print sorted array
		System.out.println("Point array after sort by Y ascending: "+Arrays.toString(pointsArr));
	}
}


// a custom class
class Point1 implements Comparable<Point1>{

	private int x;
	private int y;

	/**
	 * args-constructor
	 */
	public Point1(int x, int y) {
		setX(x);
		setY(y);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	private void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	private void setY(int y) {
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "("+this.getX()+", "+this.getY()+")";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		Point1 p = (Point1)(obj);
		return ((p.getX() == this.getX()) && 
				(p.getY() == this.getY()));
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Point1 pointObj) {
		return (this.getY() - pointObj.getY());
	}
}