package problem2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem2 {
	// Implement a method that takes a char array and a char and returns the number
	// of times the char appears in the array.
	// A 0 should be returned if the char is not in the array.

	// DO NOT CHANGE THIS METHOD HEADER. You may modify it's body.
	public static int count(char characters[], char toCount) {

		// Base Case - When the array is empty, exit.
		if (characters.length == 0) {
			return 0;
		}

		// make a new array which we can edit - newArray(which array are we copying,
		// where to start copying, where to stop copying)
		// if it matches, add 1 , remove last array char and run again.
		char[] newArray = Arrays.copyOfRange(characters, 0, characters.length - 1);

		if (characters[characters.length - 1] == toCount) {

			return 1 + count(newArray, toCount);
		}

		// if last item in array does NOT match, remove it and run again
		else
			return count(newArray, toCount);
	}

	public static void main(String[] args) {
		char arr[] = { 'f', 'a', 'c', 'a', 'a', 'e', 'e', 'f' };

		int countA = count(arr, 'a');
		System.out.println(Arrays.toString(arr));
		if (countA == 3) {
			System.out.println("[!] Correct!");
		} else {
			System.out.println("[X] Incorrect! The count should be 3 for 'a'. Returned " + countA);
		}

		int countD = count(arr, 'd');
		if (countD == 0) {
			System.out.println("[!] Correct!");
		} else {
			System.out.println("[X] Incorrect! The count should be 0 for 'd'. Returned " + countD);
		}
	}

}
