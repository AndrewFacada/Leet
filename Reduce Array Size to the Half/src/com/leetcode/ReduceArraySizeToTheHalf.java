package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ReduceArraySizeToTheHalf {

	/*
	 * You are given an integer array arr. You can choose a set of integers and
	 * remove all the occurrences of these integers in the array.Return the minimum
	 * size of the set so that at least half of the integers of the array are
	 * removed.
	 */

	public static void main(String[] args) {
		int[] a = {3,3,3,3,5,5,5,2,2,7};
		System.out.println(minSetSize(a));
	}

	public static int minSetSize(int[] arr) {
		int desiredLength = arr.length / 2; //Gives us half of arr[] length
		HashMap<Integer, Integer> hMap = new HashMap<>(); //Will hold keys = each element of arr[],  value = frequency of key
		TreeMap<Integer, ArrayList<Integer>> tMap = new TreeMap<>(); //Will eventually hold key = number of times element appears,
		int counter = 0;											 //value = arraylist of elements that appear key times
		
		for(Integer x: arr) { //Filling HM key = element from arr[] and value = how many times key appears
			if(!hMap.containsKey(x)) {
				hMap.put(x, 1);
			}else {
				hMap.put(x, hMap.get(x) + 1);
			}
		}
		
		for(Entry<Integer,Integer> entry: hMap.entrySet()) { //Iterates through HM, putting value into TM key and value being HM key
			if(!tMap.containsKey(entry.getValue())) {
				tMap.put(entry.getValue(), new ArrayList<Integer>());
			}
			
			tMap.get(entry.getValue()).add(entry.getKey());
		}
		
		Set<Integer> keySet = tMap.descendingKeySet(); //Reverses order of TM
		
		for(Integer key : keySet) { //Iterates through TM
			ArrayList<Integer> values = tMap.get(key);
			for(int i = 0; i < values.size(); i++) { //Decreases value of desiredLength per key for each element. If desiredLength is <= 0 returns counter
				counter++; // Increases per key checked
				desiredLength = desiredLength - key;
				if(desiredLength <= 0) {
					return counter;
				}
			}
		}
		
		return -1;
	}

}
