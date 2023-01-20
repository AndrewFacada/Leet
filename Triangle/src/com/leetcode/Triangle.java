package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> listFillerOne = new ArrayList<>();
		List<Integer> listFillerTwo = new ArrayList<>();
		List<Integer> listFillerThree = new ArrayList<>();
		List<Integer> listFillerFour = new ArrayList<>();
		
		listFillerOne.add(2);
		
		listFillerTwo.add(3);
		listFillerTwo.add(4);
		
		listFillerThree.add(6);
		listFillerThree.add(5);
		listFillerThree.add(6);
		
		listFillerFour.add(4);
		listFillerFour.add(1);
		listFillerFour.add(8);
		listFillerFour.add(3);
		
		list.add(listFillerOne);
		list.add(listFillerTwo);
		list.add(listFillerThree);
		list.add(listFillerFour);
		
		System.out.println(minimumTotal(list));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int result = 0;
		int smallest = Integer.MAX_VALUE;
		
		for(List<Integer> innerList: triangle) { //Iterates through list
			for(Integer number: innerList) { //Iterates through inner lists of list
				if(number < smallest) {
					smallest = number;
				}
			}
			result = result + smallest; //adds the smallest to the result
			smallest = Integer.MAX_VALUE; //Sets smallest int to max value for re-comparison
		}
		return result;
	}

}
