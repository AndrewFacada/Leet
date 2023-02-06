package com.leetcode;

public class DefangingAnIPAddress {

	/*
	 * Given a valid (IPv4) IP address, return a defanged version of that IP
	 * address.A defanged IP address replaces every period "." with "[.]".
	 */

	public static void main(String[] args) {
		String a = "1.1.1.1";
		
		System.out.println(defangIPaddr(a));
	}

	public static String defangIPaddr(String address) {
		String result = ""; //What will be returned (once filled out)
		String toBeAdded = "[.]"; //What needs to replace "."
		
		for(int i = 0; i < address.length(); i++) { //Loops through all characters of address
			if(address.charAt(i) != '.') { //If current index != '.', adds current index element to string
				result = result + address.charAt(i);
			}else { //If current index == '.', adds "[.]" to string
				result = result + toBeAdded;
			}
		}
		
		return result;
		
	}

}
