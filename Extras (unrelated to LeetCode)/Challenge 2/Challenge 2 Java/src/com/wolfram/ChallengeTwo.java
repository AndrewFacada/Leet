package com.wolfram;

public class ChallengeTwo {

	public static void main(String[] args) {

		// Tests for maxThreeEvenSum()
		int[] testOne = { 12, 13, 18, 14, 19, 20, 19, 34, 32, 19, 11, 10 };
		System.out.println(maxThreeEvenSum(testOne)); //Returns 86 because adding 3 largest even #s (34 + 32 + 20)

		int[] testTwo = { 1, 5, 13, 17, 3, 19 };
		System.out.println(maxThreeEvenSum(testTwo)); //Returns 0 because lacking 3 even #s

		
		 /* I felt as if this problem was enjoyable. So I went a little beyond and made a
		 * method that takes a sorted list of ints and returns the sum of the three
		 * largest ints (if it has them).*/
		

		// Tests for maxThreeEvenSumOrdered()
		int[] orderedTestOne = { 1, 3, 4, 5, 8 }; //returns 0 because lacking 3 even #s
		System.out.println(maxThreeEvenSumOrdered(orderedTestOne));

		int[] orderedTestTwo = { 4, 7, 9, 11, 15, 16, 18, 19 }; //returns 38 because adding 3 largest even #s (18 + 16 + 4)
		System.out.println(maxThreeEvenSumOrdered(orderedTestTwo));

	}

	public static int maxThreeEvenSum(int[] array) {
		int highMax = Integer.MIN_VALUE; // Setting
		int midMax = Integer.MIN_VALUE;
		int lowMax = Integer.MIN_VALUE;

		// Did not use sort() because single for-loop has less time complexity
		for (int i = 0; i < array.length; i++) {

			if (array[i] % 2 == 0 && highMax == Integer.MIN_VALUE) { //Sets first even # found to highMax if highMax ==
				highMax = array[i];                                  //Integer.MIN_VALUE
			}

			if (array[i] % 2 == 0) { //Checks if array[i] is even
				if (array[i] > highMax) {  //if array[i] > highMax. Sets midMax = lowMax, midMax = highMax, and then highMax = array[i]
					lowMax = midMax;
					midMax = highMax;
					highMax = array[i];
				}

				if (array[i] > midMax && array[i] < highMax) { //Sets next even # found to midMax, if array[i] > midMax
					lowMax = midMax;						   //and array[i] < highMax. Also, sets old midMax to lowMax
					midMax = array[i];
				}

				if (array[i] > lowMax && array[i] < midMax) { //Sets next even # found to lowMax if array[i] > lowMax
					lowMax = array[i];						  //and array[i] < midMax
				}
			}
		}

		if (lowMax == Integer.MIN_VALUE) { //If lowMax == Integer.MIN_VALUE, this means 3 even #s were not found and 0
			return 0;					   //is returned
		} else {
			return (highMax + midMax + lowMax); //Else 3 even #s were found and return the sum of the three
		}
	}

	public static int maxThreeEvenSumOrdered(int[] array) {
		int highMax = Integer.MIN_VALUE;
		int midMax = Integer.MIN_VALUE;
		int lowMax = Integer.MIN_VALUE;

		for (int i = array.length - 1; i >= 0; i--) { //Only reverse iterates through the array until 3 # are found
			if (array[i] % 2 == 0 && highMax == Integer.MIN_VALUE && array[i] != 0) { //sets highMax and continues
				highMax = array[i];
				continue;
			}

			if (array[i] % 2 == 0 && highMax != Integer.MIN_VALUE && midMax == Integer.MIN_VALUE && array[i] != 0) { //sets midMax and continues
				midMax = array[i];
				continue;
			}

			if (array[i] % 2 == 0 && lowMax == Integer.MIN_VALUE && array[i] != 0) { //sets lowMax and breaks loop
				lowMax = array[i];
				break;
			}
		}
		
		if (lowMax == Integer.MIN_VALUE) { //if lowMax has not been set, returns 0 because 3 even #s not found in array
			return 0;
		} else {
			return (highMax + midMax + lowMax); //returns sum of largest 3 even #s
		}
	}
}
