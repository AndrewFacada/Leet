package com.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class SortCharactersByFreq {
	
	/*Given a string s, sort it in decreasing order based on the frequency of 
	 * the characters. The frequency of a character is the number of times it 
	 * appears in the string.Return the sorted string. If there are multiple 
	 * answers, return any of them.*/

	public static void main(String[] args) {
		String a = "tree";
		
		System.out.println(frequencySort(a));
	}

	public static String frequencySort(String s) {
		HashMap<Character,Integer> map = new HashMap<>();// Keys = specific character, Values = frequency of key
		Character keyWithLargestValue = null;
		int valueOfLargestKey = Integer.MIN_VALUE;
		
		
		for(int i = 0; i < s.length(); i++) { //Adds all characters of input string into hashmap
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			}else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
		
		s = "";
		
		while(!map.isEmpty()) { //keeps track of max value for hashmap
			for(Entry<Character,Integer> entry: map.entrySet()) {
				if(entry.getValue() > valueOfLargestKey) {
					valueOfLargestKey = entry.getValue();
					keyWithLargestValue = entry.getKey();
				}
			}
			
			map.remove(keyWithLargestValue); //adds max value key to string, per values and removes from hashmap
			for(int i = valueOfLargestKey; i > 0; i--) {
				s = s + keyWithLargestValue;	
			}
			valueOfLargestKey = Integer.MIN_VALUE;
			
		}
		
		
		return s;
		

	}

}
