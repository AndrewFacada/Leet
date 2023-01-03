package com.leetcode;

public class LLW {

	/*
	 * Given a string s consisting of words and spaces, return the length of the
	 * last word in the string. A word is a maximal substring consisting of
	 * non-space characters only.
	 */

	public static void main(String[] args) {
		String a = "   sas dayas  sdsddsdsd  ";
		System.out.println(lengthOfLastWord(a));
	}

	public static int lengthOfLastWord(String s) {
		if (!s.contains(" ")) {
			return s.length();
		}

		StringBuilder convertedString = new StringBuilder(s);

		boolean ifNotSpaceFound = false;
		int lastWordCounter = 0;

		for (int i = convertedString.length() - 1; i >= 0; i--) {

			if (Character.isWhitespace(convertedString.charAt(i)) && ifNotSpaceFound == false) { 
				convertedString.deleteCharAt(i); //sees if current character is a space and a letter has not been found
				                                //if so, removes the trailing spaces
			}else {
				ifNotSpaceFound = true;
			}
			
			if(ifNotSpaceFound == true && !Character.isWhitespace(convertedString.charAt(i))) { //if a character is found and 
				lastWordCounter++; //if character has been found and is not space, increases last word count
			}
			
			if(ifNotSpaceFound == true && Character.isWhitespace(convertedString.charAt(i)) && lastWordCounter != 0) {
				return lastWordCounter; //if charcter has been found and character is
			}

		}
		
		return lastWordCounter;
	}

}
