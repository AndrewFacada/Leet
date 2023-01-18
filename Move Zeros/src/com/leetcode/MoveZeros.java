package com.leetcode;

import java.util.Arrays;

public class MoveZeros {
	
	/*Given an integer array nums, move all 0's to the end of it 
	 *while maintaining the relative order of the non-zero elements.
	 *Note that you must do this in-place without making a copy of the array.*/

	public static void main(String[] args) {
		int[] a = {3,1,0,3,12};
		
		moveZeroes(a);
	}

	public static void moveZeroes(int[] nums) {
		int cutter = -1;
		for(int i = 0; i < nums.length ; i++) {
			if(nums[i] != 0) {
				if(i != cutter + 1) {
					while(cutter < 0 || nums[cutter] != 0) {
						cutter++;
					}
					nums[cutter] = nums[i];
					nums[i] = 0;
				}else {
					cutter++;
				}
			}
		}
		
		System.out.println(Arrays.toString(nums));

	}

}
