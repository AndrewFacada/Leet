package com.wolfram.deletedups;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class DeleteDups {
	
	public static <T> List<?> deleteDuplicates(List<T> list) { // Takes any type of list
		try {
			if (list.isEmpty() || list == null || list.size() == 0) { // Checks base cases (empty/null/single element)
				return list; // return empty or single element list
			}

			LinkedHashSet<?> lHS = new LinkedHashSet<>(list); // Using a LHS because it does not allow duplicates and
															  // keeps insertion order
			List<?> result = new ArrayList<>(lHS); // Putting LHS into requested List to be returned. If list was not
												   // requested to be returned, I would have just returned the LHS
			return result;                       

		} catch (IllegalArgumentException e) {
			List<?> resultEmpty = new ArrayList<>();
			return resultEmpty; // return empty list if exception thrown

		}

	}
}
