package com.wolfram;

import java.util.ArrayList;
import java.util.List;

import com.wolfram.deletedups.DeleteDups;
import com.wolfram.gather.Gather;
import com.wolfram.tally.Tally;


public class ChallengeThree {

	public static void main(String[] args) {
		
		/*Each portion of challenge three (delete duplicats/gather/tally)has two "tests" to them. 
		 *Separated deleteDuplicates(), gather(), and tally() into their own packages and classes
		 *for better readability.
		 */
		

		// Tests for deleteDuplicates() (accepts any data type for list<...>)
		List<Integer> deleteDupTestOne = new ArrayList<>();
		deleteDupTestOne.add(22);
		deleteDupTestOne.add(19);
		deleteDupTestOne.add(19);
		deleteDupTestOne.add(6);
		System.out.println(DeleteDups.deleteDuplicates(deleteDupTestOne));

		List<String> deleteDupTestTwo = new ArrayList<>();
		deleteDupTestTwo.add("hello");
		deleteDupTestTwo.add("hi");
		deleteDupTestTwo.add("hello");
		deleteDupTestTwo.add(null);
		System.out.println(DeleteDups.deleteDuplicates(deleteDupTestTwo));
		

		// Tests for gather() (accepts any data type for list<...>)
		List<Integer> gatherTestOne = new ArrayList<>();
		gatherTestOne.add(3);
		gatherTestOne.add(1);
		gatherTestOne.add(1);
		gatherTestOne.add(2);
		gatherTestOne.add(2);
		gatherTestOne.add(1);
		System.out.println(Gather.gather(gatherTestOne));
		
		List<String> gatherTestTwo = new ArrayList<>();
		gatherTestTwo.add("Wolfram");
		gatherTestTwo.add("Wolfram");
		gatherTestTwo.add("Alpha");
		System.out.println(Gather.gather(gatherTestTwo));
		
		
		//Tests for tally() (accepts any data type for list<...>)
		List<Integer> tallyTestOne = new ArrayList<>();
		tallyTestOne.add(1);
		tallyTestOne.add(3);
		tallyTestOne.add(4);
		tallyTestOne.add(4);
		tallyTestOne.add(3);
		System.out.println(Tally.tally(tallyTestOne));
		
		List<String> tallyTestTwo = new ArrayList<>();
		tallyTestTwo.add("Wolfram");
		tallyTestTwo.add("Mathematica");
		tallyTestTwo.add("Wolfram");
		tallyTestTwo.add("Alpha");
		tallyTestTwo.add("Alpha");
		tallyTestTwo.add(null);
		System.out.println(Tally.tally(tallyTestTwo));
	}
}
