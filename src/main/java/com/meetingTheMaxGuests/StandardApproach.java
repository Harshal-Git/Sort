/**
 * 
 */
package com.meetingTheMaxGuests;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 array of time line of guests arrival & departure in HH:MM format. We need to find maximum number of 
 *		guest we can meet in the given time line.
 *
 *  -> ex:
 *  		i/p: arrival={9:00, 6:00, 7:00} & departure={10:00, 8:00, 7:30}	=> o/p: 2 
 *  			[we can meet max 2 guests between 6:00 & 7:30]
 *  
 *  		i/p: arrival={9:00, 9:40} & departure={10:00, 10:30}	=> o/p: 2
 *  
 *  		i/p: arrival={8:00, 7:00, 6:00, 5:00} & departure={8:40, 8:20, 8:30, 5:30}	=> o/p: 3
 *  
 *  		i/p: arrival={9:00, 9:40, 9:50, 11:00, 15:00, 18:00} & 
 *  			departure={9:10, 12:00, 11:20, 11:30, 19:00, 20:00}	=> o/p: 3
 *  
 *  -> Approach : we need to sort the time line and start calculating the number of guests by iterating both time lines.
 *  			If arrival time is early, then a guest came; otherwise a guest left. According to that, we can increment & 
 *  			decrement number of guests met till now and retain the maximum number of guests met.
 *  
 *  -> Original problem was already provided with time line in INT format. Ignore the conversion here.
 *  
 * -> Time complexity: 0(n * log n) [for sorting] + O(n) [for iteration] ~ 0(n * log n)	
 * -> Space complexity:	0(n)+0(n) ~ 0(n)
 * -> Auxiliary space: 0(1)
 * 
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		String [] arr1 = {"9:00", "6:00", "7:00"};
		String [] dep1 = {"10:00", "8:00", "7:30"};
		printMessage(arr1, dep1);

		// case 2
		String [] arr2 = {"9:00", "9:40"};
		String [] dep2 = {"10:00", "10:30"};
		printMessage(arr2, dep2);

		// case 3
		String [] arr3 = {"8:00", "7:00", "6:00", "5:00"};
		String [] dep3 = {"8:40", "8:20", "8:30", "5:30"};
		printMessage(arr3, dep3);

		// case 4
		String [] arr4 = {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"};
		String [] dep4 = {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};
		printMessage(arr4, dep4);
	}

	/**
	 * 
	 * @param arrivals
	 * @param departures
	 */
	private static void printMessage(String[] arrivals, String[] departures) {
		System.out.println("\nDuring Arrival: "+Arrays.toString(arrivals)+" & Departures: "+Arrays.toString(departures));
		System.out.println("Maximum number of guests can be met : "+findMaxGuests(arrivals, departures));
	}

	/**
	 * 
	 * @param arrivals
	 * @param departures
	 * @return
	 */
	private static int findMaxGuests(String[] arrivals, String[] departures) {

		int arrivalSize = arrivals.length;
		int departureSize = departures.length;
		int[] arrTime = new int[arrivalSize];
		int[] depTime = new int[departureSize];

		// convert time lines
		for(int index = 0; index < arrivalSize; index++) {
			arrTime[index] = convertTime(arrivals[index]);
		}
		for(int index = 0; index < departureSize; index++) {
			depTime[index] = convertTime(departures[index]);
		}

		// sort both time lines
		Arrays.sort(arrTime);
		Arrays.sort(depTime);

		// initializations
		int maxGuests = 0, numberOfGuest = 1;
		int arrivalIndex = 1, depatrureIndex = 0;

		// now iterate over time lines and calculate max number of guests can be met
		while(arrivalIndex < arrivalSize && depatrureIndex < departureSize) {

			// if arrival is smaller than departure : new guest can be met
			if(arrTime[arrivalIndex] <= depTime[depatrureIndex]) {
				numberOfGuest++;
				arrivalIndex++;
			} else {
				// otherwise reduce the guests met
				numberOfGuest--;
				depatrureIndex++;
			}
			// find max number of guests met till now
			maxGuests = findMax(maxGuests, numberOfGuest);
		}
		// return number of guests can be met
		return maxGuests;
	}

	/**
	 * @param maxGuests
	 * @param numberOfGuest
	 * @return
	 */
	private static int findMax(int num1, int num2) {
		return ((num1 > num2) ? (num1) : (num2));
	}

	private static int convertTime(String time) {
		String [] timeSplit = time.split(":");
		return Integer.parseInt(timeSplit[0]+timeSplit[1]);
	}
}
