package com.leetcose;

import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

public class KthLargestElementInAnArray {
	
	/*Given an integer array nums and an integer k, return the kth 
	 *largest element in the array.Note that it is the kth largest 
	 *element in the sorted order, not the kth distinct element.
	 *You must solve it in O(n) time complexity.*/

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 6, 4 };

		System.out.println(findKthLargest(a, 2));
	}

	public static int findKthLargest(int[] nums, int k) {
		int nthLargestValue = k;
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); //Sorts treemap in reverse order. 

		for (int x : nums) { //Adds nums[] to map. each number is a key. However, if a number appears twice or more, increment value for key.
			if (!map.containsKey(x)) {
				map.put(x, 1);
			} else {
				map.put(x, map.get(x) + 1);
			}
		}

		for (Entry<Integer,Integer> entry: map.entrySet()) { //Iterates through map.
			if(nthLargestValue != 0) { 
				nthLargestValue = nthLargestValue - entry.getValue(); //Subtracts value from nthLargestValue
				if(nthLargestValue <= 0 ) { //If nthLargestValue <= returns key
					return entry.getKey();
				}
			}
		}
		return -1;
	}

}
