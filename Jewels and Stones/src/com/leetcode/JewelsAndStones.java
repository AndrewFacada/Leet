package com.leetcode;

import java.util.HashMap;

public class JewelsAndStones {

	/*
	 * You're given strings jewels representing the types of stones that are jewels,
	 * and stones representing the stones you have. Each character in stones is a
	 * type of stone you have. You want to know how many of the stones you have are
	 * also jewels. Letters are case sensitive, so "a" is considered a different
	 * type of stone from "A".
	 */

	public static void main(String[] args) {
		String jewels = "aA";
		String stones = "aAAbbbb";
		
		System.out.println(numJewelsInStones(jewels, stones));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		HashMap<Character, Integer> map = new HashMap<>(); //Key = individual characters of stones. Value = frequency of key
		int counter = 0; //Will hold how many jewels are present in stones
		
		for(int i = 0; i < stones.length(); i++) { //Putting stones into HM Key = individual characters of stones. Value = frequency of key
			if(!map.containsKey(stones.charAt(i))) {
				map.put(stones.charAt(i), 1);
			}else {
				map.put(stones.charAt(i), map.get(stones.charAt(i)) + 1);
			}
		}
		
		for(int i = 0; i < jewels.length(); i++) { //Checking to see if characters of jewels are keys in HM. If so, adds value of said key to counter
			if(map.containsKey(jewels.charAt(i))) {
				counter = counter + map.get(jewels.charAt(i));
			}
		}
		return counter; //Returns number of present jewels in stones
	}

}
