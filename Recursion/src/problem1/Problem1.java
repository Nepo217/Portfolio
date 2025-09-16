package problem1;

public class Problem1 {
	// Implement a method that takes a positive integer count and a char and prints
	// on a single line the char count-times.
	// If count is 0 or negative, then nothing should happen.

	public static void printCharRow(char c, int count) {

		// Base Case
		// When the counter hits zero leave the recursive function.
		// added print line for better console formatting.

		if (count <= 0) {
			System.out.println(" ");

		}

		// print char then remove 1 from count
		else {
			System.out.print(c);
			printCharRow(c, count - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Print 4 'x' chars");
		printCharRow('x', 4);
		System.out.println("Should have printed xxxx");

		System.out.println("Print nothing with a negative count");
		printCharRow('-', -10);
		System.out.println("Nothing should have been printed.");
	}

}
