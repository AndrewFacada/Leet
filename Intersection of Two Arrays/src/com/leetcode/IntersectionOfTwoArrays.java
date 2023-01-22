package com.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class IntersectionOfTwoArrays {
	
	/*Given two integer arrays nums1 and nums2, return an array of 
	 *their intersection. Each element in the result must be unique 
	 *and you may return the result in any order.*/

	public static void main(String[] args) {
		int[] a = {1,2,2,1};
		int[] b = {2,2};
		
		System.out.println(intersection(a, b));

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(Integer x: nums1) {
			map.put(x, 1);
		}
		
		for(Integer x: nums2) {
			if(map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			}
		}
		
		int counter = 0;
		for(Entry<Integer,Integer> entry: map.entrySet()) {
			if(entry.getValue() > 1) {
				counter++;
			}else {
				map.remove(entry.getKey());
			}
		}
		
		int[] resultArray = new int[counter];
		int arraySpanner = 0;
		for(Entry<Integer,Integer> entry: map.entrySet()) {
			resultArray[arraySpanner] = entry.getKey();
			arraySpanner++;
		}
		
		return resultArray;
	}

}
