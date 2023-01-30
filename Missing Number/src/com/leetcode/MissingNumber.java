package com.leetcode;

import java.util.HashMap;

public class MissingNumber {

	/*
	 * Given an array nums containing n distinct numbers in the range [0, n], return
	 * the only number in the range that is missing from the array.
	 */

	public static void main(String[] args) {
		int[] a = { 3, 0, 1 };

		System.out.println(missingNumber(a));
	}

	public static int missingNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>(); //Will store elements of nums[] as keys. Values do not matter

		for (Integer x : nums) { //Fills HM keys with elements of nums[]
			if (!map.containsKey(x)) {
				map.put(x, 0);
			}
		}
		
		for(int i = 0; i < nums.length + 1; i++) { //Iterates 0 through nums.length + 1 checking if each key number exists
			if(!map.containsKey(i)) {
				return i; //If number does not exist in HM, returns that key
			}
		}
		
		return -1;
	}
}
