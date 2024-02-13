package com.multitone.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This a utility class to support WordProcessor with helper functions.
 */
public class WordProcessorUtil {

	/**
	 * Primary functionality: Sorting. This method takes a Map as an input, process
	 * the map and sorts it based on map value in descending order.
	 * 
	 * @param inputMap
	 * @return
	 */
	public static Map<String, Integer> sortByWordCount(Map<String, Integer> inputMap) {

		// Converting wordCountEntrySet to a List implementation, since Collections.sort
		// doesn't support Set, Comparator
		List<Entry<String, Integer>> wordCountEntryList = new ArrayList<Map.Entry<String, Integer>>(
				inputMap.entrySet());

		Collections.sort(wordCountEntryList, compareMapValues());

		Map<String, Integer> sortedByValueMap = new LinkedHashMap<String, Integer>();

		for (Entry<String, Integer> entry : wordCountEntryList) {
			sortedByValueMap.put(entry.getKey(), entry.getValue());
		}
		return sortedByValueMap;
	}

	/**
	 * Comparator to compare the values of a map and sort it.
	 * 
	 * @return
	 */
	private static Comparator<Entry<String, Integer>> compareMapValues() {
		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				Integer count1 = e1.getValue();
				Integer count2 = e2.getValue();
				// For sorting in descending order.
				return count2.compareTo(count1);
			}
		};
		return valueComparator;
	}
}
