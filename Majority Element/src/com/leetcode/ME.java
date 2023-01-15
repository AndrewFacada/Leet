package com.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class ME {
	
	/*Given an array nums of size n, return the majority element.
	 *The majority element is the element that appears more than n / 2 times.
	 *You may assume that the majority element always exists in the array.*/

	public static void main(String[] args) {
		int[] a = {2,2,1,1,1,2,2};
		
		System.out.println(majorityElement(a));
	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(Integer x: nums) {
			if(map.containsKey(x)) {
				map.put(x,map.get(x) + 1);
			}else {
				map.put(x, 1);
			}
		}
		
		int maxKey = Integer.MIN_VALUE;
		int temp = Integer.MIN_VALUE;
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > temp) {
				temp = entry.getValue();
				maxKey = entry.getKey();
			}
		}
		return maxKey;
	}

}
