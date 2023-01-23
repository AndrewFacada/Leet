package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MajorityElementTwo {

	/*Given an integer array of size n, find all 
	 * elements that appear more than  n/3  times. */

	public static void main(String[] args) {
		int[] a = {1,2};
		
		System.out.println(majorityElement(a));
	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> resultList = new ArrayList<>(); //Results will be added to this list
		int appearsMoreThan = nums.length / 3;
		
		HashMap<Integer,Integer> map = new HashMap<>(); //Will hold all elements of array based on key/value. 
														//key for element and value for frequency
		
		for(Integer x: nums) { //Checks if current element is a key in map. If so, increments value by 1, else adds to map
			if(!map.containsKey(x)) {
				map.put(x, 1);
			}else {
				map.put(x, map.get(x) + 1);
			}
		}
		
		for(Entry<Integer,Integer> entry: map.entrySet()) { //Iterates through map and checks if value is more than 
			if(entry.getValue() > appearsMoreThan) {        //desired frequency and if so, adds to resultList
				resultList.add(entry.getKey());
			}
		}
		
		return resultList;
	}

}
