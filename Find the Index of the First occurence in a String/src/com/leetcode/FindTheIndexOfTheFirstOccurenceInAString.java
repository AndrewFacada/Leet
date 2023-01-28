package com.leetcode;

public class FindTheIndexOfTheFirstOccurenceInAString {

	/*
	 * Given two strings needle and haystack, return the index of the first
	 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 */

	public static void main(String[] args) {
		String a = "mississippi";
		String b = "issip";

		System.out.println(strStr(a, b));
	}

	public static int strStr(String haystack, String needle) {
		int needleIndex = 0;

		for (int i = 0; i < haystack.length(); i++) {
			System.out.println(haystack.charAt(i));
			if(haystack.charAt(i) == needle.charAt(needleIndex)) {
				System.out.println(needle.charAt(needleIndex)+"\n");
				needleIndex++;
				
				if(needleIndex == needle.length()) {
					return i - needle.length() + 1;
				}
				
				
			}else {
				System.out.println(haystack.charAt(i) + "   Does not match " + needle.charAt(needleIndex));
				needleIndex = 0;
				
			}
		}
		return -1;
	}

}
