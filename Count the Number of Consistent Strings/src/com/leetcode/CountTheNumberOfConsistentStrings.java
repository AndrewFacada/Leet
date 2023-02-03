package com.leetcode;

import java.util.HashMap;

public class CountTheNumberOfConsistentStrings {

	/*
	 * You are given a string allowed consisting of distinct characters and an array
	 * of strings words. A string is consistent if all characters in the string
	 * appear in the string allowed.Return the number of consistent strings in the
	 * array words.
	 */

	public static void main(String[] args) {
		String allowed = "ab";
		String[] words = {"ad","bd","aaab","baa","badab"};
		
		System.out.println(countConsistentStrings(allowed, words));
	}

	public static int countConsistentStrings(String allowed, String[] words) {
		HashMap<Character, Integer> map = new HashMap<>();
		int numberOfConsistentString = 0;
		boolean checker = true;
		
			for(int i = 0; i < allowed.length(); i++) { //Adds allowed characters into Key of HM. Value does not matter.
				if(!map.containsKey(allowed.charAt(i))) {
					map.put(allowed.charAt(i), 0);
				}
			}
			
			for(int i = 0; i < words.length; i++) { //Iterating through each element
				checker = true;
				for(int j = 0; j < words[i].length(); j++) { //Iterating through each character of each element
					if(!map.containsKey(words[i].charAt(j))) { //If HM does not contain the character as a key checker switched to false
						checker = false;
					}
				}
				
				if(checker == true) { //If checker is still true after each character of element j, numberOfConsistentString++
					numberOfConsistentString++;
				}
			}
			
			return numberOfConsistentString;
			
	}

}
