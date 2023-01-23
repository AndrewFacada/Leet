package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ProductOfArrayExceptSelf {

	/*
	 * Given an integer array nums, return an array answer such that answer[i] is
	 * equal to the product of all the elements of nums except nums[i].Theproduct of
	 * any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.You
	 * must write an algorithm that runs in O(n) time and without using the division
	 * operation.
	 */

	public static void main(String[] args) {
		int[] a = {1,1};
		
		System.out.println(Arrays.toString(productExceptSelf(a)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] resultArray = new int[nums.length]; //Results will be stored in this array
		List<Integer> list = new ArrayList<>();
		int currentIndex = 0; 
		int product = 1;
		
		for(Integer x: nums) {
			list.add(x);
		}
		
		while(currentIndex < list.size()) { //While currentIndex < nums.length will iterate through nums
			for(int i = 0; i < list.size(); i++) {
				if(i == currentIndex) { //Skips current element, not to add to product (if element matches current index)
					continue;
				}else {
					product *= list.get(i);
				}
			}
			resultArray[currentIndex] = product;
			product = 1; //Resets product for next evaluation
			currentIndex++; //Increments for next index of array
		}
		
		return resultArray;
		
		
		
		
		
		
		
		/*int[] resultArray = new int[nums.length]; //Results will be stored in this array
		int currentIndex = 0; //For spanning resultArray
		int product = 1; //For calculating product
		
		while(currentIndex < nums.length) { //While currentIndex < nums.length will iterate through nums
			for(int i = 0; i < nums.length; i++) {
				if(i == currentIndex) { //Skips current element, not to add to product (if element matches current index)
					continue;
				}else {
					product *= nums[i];
				}
			}
			resultArray[currentIndex] = product;
			product = 1; //Resets product for next evaluation
			currentIndex++; //Increments for next index of array
		}
		
		return resultArray;*/
	}

}
