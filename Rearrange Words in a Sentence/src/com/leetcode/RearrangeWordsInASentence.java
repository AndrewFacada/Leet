package com.leetcode;

import java.util.ArrayDeque;
import java.util.Map.Entry;
import java.util.TreeMap;

public class RearrangeWordsInASentence {

	/*
	 * Given a sentence text (A sentence is a string of space-separated words) in
	 * the following format:First letter is in upper case.Each word in text are
	 * separated by a single space.Your task is to rearrange the words in text such
	 * that all words are rearranged in an increasing order of their lengths. If two
	 * words have the same length, arrange them in their original order.Return the
	 * new text following the format shown above.
	 */

	public static void main(String[] args) {
		String a = "Leetcode is cool an";
		System.out.println(arrangeWords(a));

	}

	public static String arrangeWords(String text) {
		text.toLowerCase(); //Sets all characters in String to lower case
		String[] singleWords = text.split(" "); //Array with each element being a separate word in input String
		TreeMap<Integer, ArrayDeque<String>> treeMap = new TreeMap<>(); //TreeMap where Key = word length and Value = AD for keeping order
		
		for(String x: singleWords) { //Filling TreeMap with keys/values
			if(!treeMap.containsKey(x.length())) {
				treeMap.put(x.length(), new ArrayDeque<String>());
			}
			
			treeMap.get(x.length()).add(x);
		}
		
		text = ""; //Clears input String. Will be using it as returned result
		
		//System.out.println(treeMap);
		
		for(Entry<Integer,ArrayDeque<String>> entry: treeMap.entrySet()) { //Iterates through TreeMaop
			ArrayDeque<String> values = entry.getValue();
			
			while(!values.isEmpty()) { // Pops all values of ArrayDeque in order and puts into String
				text = text + values.pop();
				text = text + " ";
			}
		}
		
		text = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase(); //Makes first character in String upper case 
		
		return text.trim(); //Returns String and removes last space.
	}

}
