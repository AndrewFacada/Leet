package com.leetcode;

import java.util.Arrays;

public class MSA {
	
	/*You are given two integer arrays nums1 and nums2, 
	 * sorted in non-decreasing order, and two integers
	 * m and n, representing the number of elements in
	 * nums1 and nums2 respectively.
	 * Merge nums1 and nums2 into a single array sorted 
	 * in non-decreasing order.
	 * The final sorted array should not be returned by 
	 * the function, but instead be stored inside the array
	 * nums1. To accommodate this, nums1 has a length of m + n, 
	 * where the first m elements denote the elements that should 
	 * be merged, and the last n elements are set to 0 and should 
	 * be ignored. nums2 has a length of n.
	 */

	public static void main(String[] args) {
		int[] first = {1,2,3,0,0,0};
		int[] second = {2,5,6};
		
		int numElementsInFirst = 3; //will be m
		int numElementsInSecond = 3; //will be n
		
		merge(first, numElementsInFirst, second, numElementsInSecond);
	}
	
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        m--;
	        n--;
	        int index = nums1.length - 1;
	        
	        while(index >= 0){
	        	if(m < 0) {
	        		nums1[index] = nums2[n--];
	        	}else if(n < 0) {
	        		nums1[index] = nums1[m--];
	        	}else {
	        		if(nums1[m] > nums2[n]) {
	        			nums1[index] = nums1[m--];
	        		}else {
	        			nums1[index] = nums2[n--];
	        		}
	        	}
	        	index--;
	        }
	        
	        System.out.println(Arrays.toString(nums1));
	}

}
