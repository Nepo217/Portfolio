package problem5;

public class Problem5 {
	// DO NOT CHANGE THIS METHOD HEADER. You may modify it's body.
	// You should implement a separate method that accepts additional information
	// that does the actual processing and returns the max value. For instance,
	// you'll need
	// an index variable.

	// Part A - Implement a method that takes an integer array and returns the
	// maximum value in the array.
	// If the array is empty, then throw an IllegalArgumentException the contains a
	// message about the array being empty.

	// I need to create a indexer as well as a variable to store the max value.
	public int maxFinder(int idx, int max) {
		idx = 0;
		max = 0;
		return max;
	}

	public static int maxValue(int arr[]) {

		// Base Case - When you reach the end of the array, exit the recursion function
		// and return the maxValue.
		// I need to step through the array and if the item at the current index is
		// bigger then the current max value, overwrite it and move on to the next.
		// If the item at the current index is smaller than the current max value, do
		// nothing, and move on to the next one.

		if (arr == null)
			throw new IllegalArgumentException("Error: Array is empty.");

		int max = 0;
		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] > max)
				arr[idx] = max;
		}

		return max;
	}

	// DO NOT CHANGE THIS METHOD HEADER. You may modify it's body.
	// You should implement a separate method that accepts additional information
	// that does the actual processing and returns the min value. For instance,
	// you'll need
	// an index variable.

	// Part B - Implement a method takes an integer array and returns the minimum
	// value in the array.
	// If the array is empty, then throw an IllegalArgumentException the contains a
	// message about the array being empty.

	public static int minValue(int arr[]) {

		// Base Case - When you reach the end of the array, exit the recursion function
		// and return the minValue.

		// I need to create a indexer as well as a variable to store the minimum value.

		// I need to step through the array and if the item at the current index is
		// bigger then the current minimum value, over write it and move on to the next.

		return 0;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 3, 3, 3, 4, 5, 4, 4, 3, 4, 5, 2 };

		System.out.println("Testing maxValue");
		int max = maxValue(arr);
		if (max == 5) {
			System.out.println("[!] Correct!");
		} else {
			System.out.println("[X] Incorrect! Value should be 5 for max call.  Returned " + max);
		}

		System.out.println("Testing minValue");
		int min = minValue(arr);
		if (min == 1) {
			System.out.println("[!] Correct!");
		} else {
			System.out.println("[X] Incorrect! Value should be 1 for min call.  Returned " + min);
		}

		System.out.println("Testing IllegalArgumentException for maxValue.");
		try {
			int nums[] = {};
			maxValue(nums);
			System.out
					.println("[X] Incorrect! IllegalArgumentException should be returned for empty array in maxValue.");
		} catch (IllegalArgumentException iae) {
			System.out.println("[!] Correct!");
		}

		System.out.println("Testing IllegalArgumentException for minValue.");
		try {
			int nums[] = {};
			minValue(nums);
			System.out
					.println("[X] Incorrect! IllegalArgumentException should be returned for empty array in minValue.");
		} catch (IllegalArgumentException iae) {
			System.out.println("[!] Correct!");
		}
	}

}
