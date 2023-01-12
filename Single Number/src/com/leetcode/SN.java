package com.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class SN {
	
	/*Given a non-empty array of integers nums, every element appears 
	 *twice except for one. Find that single one.
	 *You must implement a solution with a linear runtime complexity 
	 *and use only constant extra space.
	 */

	public static void main(String[] args) {
		int[] a = { 1, 3, 6, 11, 76, 4, 1, 6, 3, 76, 4 };
		System.out.println(singleNumber(a));
	}

	public static int singleNumber(int[] nums) {
		HashMap<Integer,Integer> hMap = new HashMap<>();
		
		for(Integer x: nums) {
			if(hMap.containsKey(x)) {
				hMap.put(x, hMap.get(x)+1);
			}else {
				hMap.put(x, 1);
			}
		}
		
		for(Entry<Integer,Integer> entry: hMap.entrySet()) {
			if(entry.getValue().equals(1)) {
				return entry.getKey();
			}
		}
		
		return -1;
	}

}
