package com.leetcode;

public class MS {

	/*
	 * Given two non-negative integers num1 and num2 represented as strings, return
	 * the product of num1 and num2 , also represented as a string.
	 */

	public static void main(String[] args) {
		String numOne = "123456789";
		String numTwo = "987654321";
		
		System.out.println(multiply(numOne,numTwo));
	}

	public static String multiply(String num1, String num2) {
		long holderOne = Integer.parseInt(num1);
		long holderTwo = Integer.parseInt(num2);
		
		holderOne = holderOne * holderTwo;
		
		return Long.toString(holderOne);
	}

}
