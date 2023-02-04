package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	/*
	 * Given an array nums of n integers where nums[i] is in the range [1, n],
	 * return an array of all the integers in the range [1, n] that do not appear in
	 * nums.
	 */

	public static void main(String[] args) {
		int[] a = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(a));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>(); //Result list
		HashSet<Integer> hSet = new HashSet<Integer>(); //Will hold all unique elements of nums[]
		
		for(Integer x: nums) { //Adds all unique elements of nums[] to HS
			if(!hSet.contains(x)) {
				hSet.add(x);
			}
		}
		
		for(int i = 1; i < nums.length + 1; i++) { //Checks to see if certain number is or is not in HS
			if(!hSet.contains(i)) { //If number is not  in HS, adds to list
				list.add(i);
			}
		}
		
		return list;
	}

}
