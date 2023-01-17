package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FUCIAS {

	/*Given a string s, find the first non-repeating character 
	 *in it and return its index. If it does not exist, return -1.*/
	
	public static void main(String[] args) {
		String a = "leetcode";
		
		System.out.println(firstUniqChar(a));
	}

	public static int firstUniqChar(String s) {
		Character charHolder = null;
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			charHolder = s.charAt(i);
			if(map.containsKey(charHolder)) {
				map.put(charHolder, map.get(charHolder) + 1);
			}else {
				map.put(charHolder, 1);
			}
		}
		
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry
			}
		}
		
		
	}
}
