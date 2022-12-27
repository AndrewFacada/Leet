package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LCPN {

	/*
	 * Given a string containing digits from 2-9 inclusive, return all possible
	 * letter combinations that the number could represent. Return the answer in any
	 * order. A mapping of digits to letters (just like on the telephone buttons) is
	 * given below. Note that 1 does not map to any letters.
	 */
	
	//Can be done faster.

	public static void main(String[] args) {
		String test = "34";

		System.out.println(letterCombinations(test));
	}

	public static List<String> letterCombinations(String digits) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");

		List<String> list = new ArrayList<String>();

		if (digits.isEmpty() || digits.equals("1") || digits.equals("0")) {
			return list;
		}

		if (digits.length() == 1 ) { //runs through if length of String  = 1
			String tempOne = map.get(digits);
			Character tempTwo = null;
			for(int i = 0; i < tempOne.length(); i++) {
				tempTwo = tempOne.charAt(i);
				list.add(tempTwo.toString());
			}
			return list;
		}

		if (digits.length() == 2) { //runs through if length of String  = 2
			Character charTempOne = digits.charAt(0);
			Character charTempTwo = digits.charAt(1);
			String tempOne = map.get(charTempOne.toString());
			String tempTwo = map.get(charTempTwo.toString());
			String holder = "";
			for(int i = 0; i < tempOne.length(); i++) {
				for(int j = 0;j < tempTwo.length(); j++){
					holder = holder + tempOne.charAt(i) + tempTwo.charAt(j);
					list.add(holder);
					holder = "";
					}
			}
			return list;
		}
		
		if(digits.length() == 3) {//runs through if length of String  = 3
			Character charTempOne = digits.charAt(0);
			Character charTempTwo = digits.charAt(1);
			Character charTempThree = digits.charAt(2);
			String tempOne = map.get(charTempOne.toString());
			String tempTwo = map.get(charTempTwo.toString());
			String tempThree = map.get(charTempThree.toString());
			String holder = "";
			for(int i = 0; i < tempOne.length(); i++) {
				for(int j = 0;j < tempTwo.length(); j++) {
					for(int a = 0;a < tempThree.length(); a++) {
						holder = holder + tempOne.charAt(i) + tempTwo.charAt(j) + tempThree.charAt(a);
						list.add(holder);
						holder = "";
					}
					
				}
			}
			return list;
		}
		
		if(digits.length() == 4) { //runs through if length of String  = 3
			Character charTempOne = digits.charAt(0);
			Character charTempTwo = digits.charAt(1);
			Character charTempThree = digits.charAt(2);
			Character charTempFour = digits.charAt(3);
			String tempOne = map.get(charTempOne.toString());
			String tempTwo = map.get(charTempTwo.toString());
			String tempThree = map.get(charTempThree.toString());
			String tempFour = map.get(charTempFour.toString());
			String holder = "";
			for(int i = 0; i < tempOne.length(); i++) {
				for(int j = 0; j < tempTwo.length(); j++) {
					for(int a = 0; a < tempThree.length(); a++) {
						for(int b = 0; b < tempFour.length(); b++) {
							holder = holder + tempOne.charAt(i) + tempTwo.charAt(j) + tempThree.charAt(a) + tempFour.charAt(b);
							list.add(holder);
							holder = "";
						}
					}
					
				}
			}
			return list;
		}
		return list;
	}

}
