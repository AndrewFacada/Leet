package com.leetcode;

public class HandOfStraights {

	/* Alice has some number of cards and she wants to rearrange the cards into
	 * groups so that each group is of size groupSize, and consists of groupSize
	 * consecutive cards.Given an integer array hand where hand[i] is the value
	 * written on the ith card and an integer groupSize, return true if she can
	 * rearrange the cards, or false otherwise.
	 */

	public static void main(String[] args) {
		int[] a = {1,2,3,6,2,3,4,7,8};
		int brokenUpInto = 3;
		
		System.out.println(isNStraightHand(a,brokenUpInto));
	}

	public static boolean isNStraightHand(int[] hand, int groupSize) {
		if(hand.length % groupSize == 0){ //If hand.length divided by groupSize equals 0 for the remainder return true
			return true;
		}
		
		return false;
	}

}
