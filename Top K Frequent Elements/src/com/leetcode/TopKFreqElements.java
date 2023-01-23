package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class TopKFreqElements {

	/*
	 * Given an integer array nums and an integer k, return the k most frequent
	 * elements. You may return the answer in any order.
	 */

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 3 };

		System.out.println(Arrays.toString(topKFrequent(a, 2)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		int counter = k;
		int[] resultArray = new int[k]; // int array with length of k
		int indexIncrementer = 0;
		HashMap<Integer, Integer> map = new HashMap<>(); // Map for keeping track of how many times a number appears

		for (Integer x : nums) { // Populates map with nums. If element is already in map, increases that key's
									// value
			if (!map.containsKey(x)) {
				map.put(x, 1);
			} else {
				map.put(x, map.get(x) + 1);
			}
		}

		int maxValue = Integer.MIN_VALUE;
		int holdCurrentMaxKey = 0;
		while(counter > 0) {
			for(Entry<Integer,Integer> entry: map.entrySet()) { //Iterates through map (without throwing concurrent modification error)
				if(entry.getValue() > maxValue) { 	            //and takes largest value and sets key per largest value
					maxValue = entry.getValue();
					holdCurrentMaxKey = entry.getKey();
				}
			}
			
			resultArray[indexIncrementer] = holdCurrentMaxKey; //Sets current largest value key to resultArray
			map.remove(holdCurrentMaxKey); //Removes current largest amount value/key
			indexIncrementer++; //Increments resultArray index
			counter--; //Decrements counter per how many based on kth freq
			maxValue = Integer.MIN_VALUE; //Resets for another test
		}

		return resultArray;

	}

}
