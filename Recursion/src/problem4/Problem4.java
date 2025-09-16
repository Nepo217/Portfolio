package problem4;

import java.util.Arrays;

public class Problem4 {

	// Part A - Implement a recursive method that takes an array of integers and
	// prints it in reverse.
	// Each number should be on a separate line. You may start from either the front
	// or the back of the array so long as the elements are printed in reverse
	// order.
	// If the array is empty, then nothing should be printed.

	// Reverse order for this problem means from N to 0 where N is the last index of
	// the array.
	// So if an array has a last index of 3 then reverse order would be 3, 2, 1, 0.

	// DO NOT CHANGE THIS METHOD HEADER. You may modify it's body.

	public static void reverseArrayPartA(int arr[]) {

		// THis keeps failing because I am resetting the variables in the recursion.

		// declare variables
		int i;
		int idx = arr.length - 1;

		// Base Case if Index is 0 then leave recursive function.
		if (idx < 0) {
			return;
		}

		// if index is still in the array, print last integer in array and decrement
		// index by one, then run again.
		else if (idx >= 0) {
			i = idx;
			System.out.println(arr[i]);
			idx--;
			System.out.println(idx);
			// reverseArrayPartA(arr);
		}

	}

	// DO NOT CHANGE THIS METHOD HEADER. You may modify it's body.
	// Part B - Implement a method that reverses the array passed to it so that the
	// element at index 0 is now at index N, element at index 1 is now at index N -
	// 1, and so on.
	// This should be performed on the original array. No additional arrays should
	// be used. If the array is empty, then nothing should happen.

	// You should implement a separate method that accepts additional information
	// that does the actual processing and reversing of array.
	public static void reverseArrayPartB(int arr[]) {

	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };

		System.out.println("Checking Reverse Part A");
		System.out.println(Arrays.toString(arr));
		reverseArrayPartA(arr);
		System.out.println("Should print 3 2 1 each on a separate line.");

		System.out.println("\nChecking Reverse Part B");
		int check[] = { 3, 2, 1 };
		reverseArrayPartB(arr);
		boolean correct = true;
		for (int i = 0; i < check.length; i++) {
			if (arr[i] != check[i]) {
				String res = "Should be %s.  Produced %s";
				String arrStr = Arrays.toString(arr);
				String checkStr = Arrays.toString(check);
				System.out.println("[X] Incorrect!" + String.format(res, arrStr, checkStr));
				correct = false;
				break;
			}
		}

		if (correct) {
			System.out.println("[!] Correct!");
		}
	}
}
