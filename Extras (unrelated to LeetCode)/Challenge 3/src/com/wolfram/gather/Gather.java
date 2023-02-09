package com.wolfram.gather;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Gather {
	public static <T> List<List<?>> gather(List<T> list) {
		try {
			LinkedHashMap<T, Integer> map = new LinkedHashMap<>();// Used for counting how many times a value appears
			List<List<?>> resultList = new ArrayList<>(); //List of Lists that will be returned

			while (!list.isEmpty()) { //Counts time a specific element of the list appears Ex. [1,1,3]  key = 1, value = 2   and key = 3, value = 1
				if (map.containsKey(list.get(0))) { //If element is already in LHM, increments value by 1
					map.put(list.get(0), map.get(list.get(0)) + 1);
					list.remove(0); //After element value is incremented in LHM, it is removed from list.
				} else {
					map.put(list.get(0), 1); //if element is not in the LHM, it is added and value set to one
					list.remove(0); //After added to LHM, element removed from list
				}
			}
			
			for(T key : map.keySet()) { //Iterates through the map
				List<T> insertionList = new ArrayList<>();
				while(map.get(key) != 0) { // if the value is not 0, we add the key to the insertionList and then decrement that key's value in the map by 1
					insertionList.add(key);
					map.put(key,map.get(key)-1);
					
				}
				resultList.add(insertionList); //when the key's value is 0, add the insertionList to the resultList
			}
			return resultList;

		} catch (IllegalArgumentException e) {
			List<List<?>> emptyList = new ArrayList<>();
			return emptyList;
		}

	}
}
