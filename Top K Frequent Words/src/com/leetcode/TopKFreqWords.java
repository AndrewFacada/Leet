package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopKFreqWords {

	/*
	 * Given an array of strings words and an integer k, return the k most frequent
	 * strings.Return the answer sorted by the frequency from highest to lowest.
	 * Sort the words with the same frequency by their lexicographical order.
	 */

	public static void main(String[] args) {
		String[] a = {"day","sunny","is","the"};
		System.out.println(topKFrequent(a, 4));
	}

	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		TreeMap<Integer, TreeSet<String>> treeMap = new TreeMap<>(/*Collections.reverseOrder()*/); //Reversed order TreeSet
		List<String> list = new ArrayList<>(); //For results

		for (String x : words) { //Storing all elements of words[] into HM. Key= word Value= # of times word appears
			if (!hashMap.containsKey(x)) {
				hashMap.put(x, 1);
			} else {
				hashMap.put(x, hashMap.get(x) + 1);
			}
		}

		for (Entry<String, Integer> entry : hashMap.entrySet()) { //Sets Keys = # of appearances and Values = words (TreeSet for order) into TreeMap
			if (!treeMap.containsKey(entry.getValue())) {
				treeMap.put(entry.getValue(), new TreeSet<String>());
			}

			treeMap.get(entry.getValue()).add(entry.getKey());
		}

		for (Entry<Integer, TreeSet<String>> entry : treeMap.entrySet()) { //Adds values to List (keeping order because of TreeSet)
			TreeSet<String> values = entry.getValue();
			list.addAll(values);
		}

		while(list.size() != k) { //Removes all undesired values
			list.remove(0);
		}
		
		return list;

	}

}
