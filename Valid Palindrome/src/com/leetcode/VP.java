package com.leetcode;

public class VP {
	
	/*A phrase is a palindrome if, after converting all uppercase 
	 * letters into lowercase letters and removing all non-alphanumeric 
	 * characters, it reads the same forward and backward. Alphanumeric 
	 * characters include letters and numbers.*/
	
	public static void main(String[] args) {
		String first = "A man, a plan, a canal: Panama";
		
		System.out.println(isPalindrome(first));

	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]", "");
		
		String backwards = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			backwards = backwards + s.charAt(i);
			
		}
		
		if(s.equals(backwards)) {
			return true;
		}else {
			return false;
		}

	}

}
