package com.leetcode;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

	/*Given the array nums, for each nums[i] find out how many numbers 
	 *in the array are smaller than it. That is, for each nums[i] you have 
	 *to count the number of valid j's such that j != i and nums[j] < nums[i].
	 * 
	 * Return the answer in an array.*/
	
	public static void main(String[] args) {
		int[] a = {8,1,2,2,3};
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int current = 0;
		int large = Integer.MIN_VALUE;
		int[] result = new int[nums.length + 1];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(nums)
			}
			
		}
	}

}
