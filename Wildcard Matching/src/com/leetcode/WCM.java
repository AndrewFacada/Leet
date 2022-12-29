package com.leetcode;

public class WCM {

	/*Given an input string (s) and a pattern (p), implement wild-card
	 *pattern matching with support for '?' and '*' where:
	 *'?' Matches any single character.
	 *'*' Matches any sequence of characters (including the empty sequence).*/
	
	public static void main(String[] args) {
		String first = "abc";
		String second = "a?c";
		
		System.out.println(isMatch(first,second));

	}

	public static boolean isMatch(String s, String p) {
		if(s.equals(p)) { //base case
			return true;
		}
		
		if(p.length() == 1 && p.contains("*")) {
			return true;
		}
		
		if(p.contains("*") && !p.contains("?")) {
			return true;
		}
		
		if(s.length() != p.length()  && !p.equals("*")){ //TRIAL
			return false;
		}
		
		if(s.length() == p.length() && p.contains("*") && p.contains("?")) {
			return false;
		}
		
		for(int i = 0; i < s.length() ; i++) {
			
			
			if((p.charAt(i) != '?') & (s.charAt(i) != p.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
