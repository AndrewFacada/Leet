package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class FindAllDupsInAnArray {
	
	/*Given an integer array nums of length n where all the integers of nums are in 
	 *the range [1, n] and each integer appears once or twice, return an array of all 
	 *the integers that appears twice.You must write an algorithm that runs in O(n) time 
	 *and uses only constant extra space.*/

	public static void main(String[] args) {
		int[] a = {4,3,2,7,8,2,3,1};
		
		System.out.println(findDuplicates(a));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> resultList = new ArrayList<>(); //Will contain all duplicates and be returned
		
		HashMap<Integer,Integer> map = new HashMap<>(); //Figures out duplicates based on key/value pair in lower for-loop
		
		for(int i = 0; i < nums.length; i++) { //Puts all values into HashMap. If nums[i] is already a key, it increments key's value
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		
		for(Entry<Integer,Integer> entry: map.entrySet()) { //If value is > 1 (aka it shows more than once), it is added to the resultList
			if(entry.getValue() > 1) {
				resultList.add(entry.getKey());
			}
		}
		
		return resultList;
	}

}
