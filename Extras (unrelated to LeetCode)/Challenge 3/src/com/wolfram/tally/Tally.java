package com.wolfram.tally;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Tally {
	public static <T> HashMap<?, ?> tally(List<T> list) {
		try {
			LinkedHashMap<T, Integer> map = new LinkedHashMap<>();// Used for counting how many times a value appears + order
			
			while (!list.isEmpty()) { //Counts time a specific element of the list appears Ex. [1,1,3]  key = 1, value = 2   and key = 3, value = 1
				if (map.containsKey(list.get(0))) { //If element is already in LHM, increments value by 1
					map.put(list.get(0), map.get(list.get(0)) + 1);
					list.remove(0); //After element value is incremented in LHM, it is removed from list.
				} else {
					map.put(list.get(0), 1); //if element is not in the LHM, it is added and value set to one
					list.remove(0); //After added to LHM, element removed from list
				}
			}
			
			return map;
			
		} catch (IllegalArgumentException e) {
			LinkedHashMap<T, Integer> emptyMap = new LinkedHashMap<>();
			return emptyMap;
		}

	}
}
