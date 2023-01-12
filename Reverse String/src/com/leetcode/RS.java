package com.leetcode;

import java.util.Arrays;

public class RS {
	
	/*Write a function that reverses a string. The input string 
	 *is given as an array of characters s.
	 *You must do this by modifying the input 
	 *array in-place with O(1) extra memory.*/

	public static void main(String[] args) {
		char[] a = { 'a', 'c', 'w', 'r', 'g' };
		reverseString(a);
	}

	public static void reverseString(char[] s) {
		int left = 0;
		int end = s.length - 1;
		while (left < end) {
			char temp = s[left];
			s[left] = s[end];
			s[end] = temp;

			left++;
			end--;
		}
		System.out.println(Arrays.toString(s));
	}

}
