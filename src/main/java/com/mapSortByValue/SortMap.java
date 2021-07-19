/**
 * 
 */
package com.mapSortByValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Harshal-Git
 *
 *	-> Sort a map by it's Value. 
 */
public class SortMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Parth");
		map.put(2, "Ravi");
		map.put(3, "Amar");
		map.put(4, "Yatan");
		map.put(5, "Rajesh");
		System.out.println("Input map: "+map.toString());
		
		// get list of EntryMap set & sort it
		List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		// prepare a new linked hashmap which will maintain insertion order
		Map<Integer, String> newMap = new LinkedHashMap<>();
		for(Map.Entry<Integer, String> mapEntry : list) {
			newMap.put(mapEntry.getKey(), mapEntry.getValue());
		}
		System.out.println("Sorted map: "+newMap.toString());
	}
}
