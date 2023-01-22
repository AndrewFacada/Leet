package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class IntersectionOfTwoArrays {

	/*
	 * Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must be unique and you may return
	 * the result in any order.
	 */

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 1 };
		int[] b = { 2, 2 };

		System.out.println(Arrays.toString(intersection(a,b)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(Integer x: nums1) { //Fills map with all elements of nums1
			if(!map.containsKey(x)) {
				map.put(x, 1);
			}
		}
		
		for(Integer x: nums2) { //Checks elements of nums2 to see if that number is already a key in map. If so, increments value of that key
			if(map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			}
		}
		
		int resultArrayLength = 0;
		for(Entry<Integer,Integer>entry: map.entrySet()) { //If value of key > 1, it means number is present in both arrays
			if(entry.getValue() > 1) {					   //getting length of result array
				resultArrayLength++;
			}
		}
		
		int[] resultArray = new int[resultArrayLength]; //Result array with proper length
		int indexSpanner = 0;
		for(Entry<Integer,Integer> entry: map.entrySet()) {
			if(entry.getValue()  > 1) { //If value > 1  (means value is present in both arrays) add it to result array
				resultArray[indexSpanner] = entry.getKey();
				indexSpanner++; //incrementing result array index
			}
		}
		
		return resultArray;
		
		

	}

}
