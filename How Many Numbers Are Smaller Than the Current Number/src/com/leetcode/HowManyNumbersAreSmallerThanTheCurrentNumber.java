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
		
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(a)));
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] result = new int[nums.length]; //Creates new array with same length as input array (nums[])
		int goThroughResultArray = 0; //Keeps track of element for result array
		
		for(int i = 0; i < nums.length; i++) { //Iterates through nums[]
			
			for(int j = 0; j < nums.length; j++) { //Also iterates through nums[]
				if(nums[j] == nums[i]) { //if nums[j] == nums[i] continue
					continue;
				}
				
				if(nums[i] > nums[j]) { //if nums[i] > nums[j] increment for result array because element is smaller
					result[goThroughResultArray]++;
				}
			}
			goThroughResultArray++; //Goes to next element in result array
		}
		
		return result;
	}

}
