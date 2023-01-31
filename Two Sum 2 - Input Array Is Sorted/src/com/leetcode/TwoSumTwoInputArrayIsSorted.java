package com.leetcode;

import java.util.Arrays;

public class TwoSumTwoInputArrayIsSorted {

	public static void main(String[] args) {
		int[] a = {-1,0,2,3,5,7,9,10};
		int tar = 9;
		
		System.out.println(Arrays.toString(twoSum(a, tar)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for(int i = 0; i < numbers.length; i++) { //Iterates through array
			
			for(int j = 0; j < numbers.length; j++) { //Iterates through same array, without including current index of outter array
				if(j == i) { //Making sure current index of outter array is skipped
					continue;
				}
				
				if(numbers[j] > target){ //If value of numbers[j] is < than target, will break
                    break;
                }
				
				if(numbers[i] + numbers[j] == target) { //Sets two indexes that equal target (if they exist)
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		
		return null;
	}

}
