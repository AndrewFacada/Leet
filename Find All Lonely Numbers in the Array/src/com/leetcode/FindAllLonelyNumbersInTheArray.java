package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class FindAllLonelyNumbersInTheArray {
	
	/*You are given an integer array nums. A number x is lonely 
	 *when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) 
	 *appear in the array.Return all lonely numbers in nums.*/

	public static void main(String[] args) {
		int[] a = {1,3,5,3};
		System.out.println(findLonely(a));

	}

	public static List<Integer> findLonely(int[] nums) {
		List<Integer> list = new ArrayList<>(); //Will hold all lonely numbers
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(Integer x: nums) { //Adds all elements of nums[] to HM. Keys= specific element and Value = how many times specific element occurs
			if(!map.containsKey(x)) {
				map.put(x, 1);
			}else {
				map.put(x, map.get(x) + 1);
			}
		}
		
		for(Entry<Integer,Integer> entry: map.entrySet()) { //Checks if number is lonely and if not, sets value of that specific key to 0
			if(map.containsKey(entry.getKey() - 1) || map.containsKey(entry.getKey() + 1) || entry.getValue() > 1) {
				map.put(entry.getKey(), 0);
			}
			
			while(entry.getValue() > 0) { //While value is greater than 0, adds key to list. While decrementing value each time
				list.add(entry.getKey());
				map.put(entry.getKey(), entry.getValue() - 1);
			}
		}
		
		return list;
	}

}
