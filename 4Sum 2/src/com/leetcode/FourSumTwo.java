package com.leetcode;

import java.util.HashMap;

public class FourSumTwo {

	public static void main(String[] args) {
		int[] a = {1,2};
		int[] b = {-2,-1};
		int[] c = {-1,2};
		int[] d = {0,2};
		
		System.out.println(fourSumCount(a, b, c, d));
	}

	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int a: nums1) {
	        for (int b: nums2) {
	            map.put(a+b, map.getOrDefault(a+b, 0) + 1);
	        }
	    }
	    int count = 0;
	        
	    for (int c: nums3) {
	        for (int d: nums4) {
	            count += map.getOrDefault(-c-d, 0);
	        }
	    }
	        
	    return count;
	}

}
