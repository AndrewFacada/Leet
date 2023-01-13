package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class SC {
	
	/*Given an array nums with n objects colored red, white, or blue, sort them in-place 
	 *so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
	 *We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
	 * You must solve this problem without using the library's sort function.*/

	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		sortColors(nums);

	}

	public static void sortColors(int[] nums) {
		int counter = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(Integer x: nums) {
			if(!map.containsKey(x)) {
				map.put(x, 1);
			}else {
				map.put(x, map.get(x)+1);
			}
		}
		
		while(!map.isEmpty()) {
			if(map.containsKey(0)) {
				nums[counter] = 0;
				counter++;
				map.put(0, map.get(0) - 1);
				if(map.get(0) == 0) {
					map.remove(0);
				}
				
			}else if(map.containsKey(1)){
				nums[counter] = 1;
				counter++;
				map.put(1, map.get(1) - 1);
				if(map.get(1) == 0) {
					map.remove(1);
				}	
				
			}else if(map.containsKey(2)) {
				nums[counter] = 2;
				counter++;
				map.put(2, map.get(2) - 1);
				if(map.get(2) == 0) {
					map.remove(2);
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
