package problem3;

import java.util.Arrays;

public class Problem3 {

	// DO NOT CHANGE THIS METHOD HEADER. You may modify it's body.
	// You should implement a separate method that accepts additional information
	// that does the actual processing and modification of array. For instance,
	// you'll need
	// an index variable.

	// Implement a method which takes an array of 1's and 0's. You should turn all
	// 1's to 0's and all 0's to 1's.
	// This should be done on the original array. No additional arrays should be
	// used. If the array is empty, then nothing should happen.

	public static void negation(int arr[]) {

		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] == 0)
				arr[idx] = 1;
			else
				arr[idx] = 0;
		}

	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
		System.out.println(Arrays.toString(arr));

		negation(arr);
		System.out.println("Changed to " + Arrays.toString(arr));
		boolean correct = true;
		int check[] = { 1, 1, 0, 0, 1, 0, 1, 0, 0, 0 };
		for (int i = 0; i < arr.length; i++) {
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
