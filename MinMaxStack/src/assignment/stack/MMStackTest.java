package assignment.stack;

import common.EmptyCollectionException;

public class MMStackTest {

	private static void test1() {
		MinMaxStack<Integer> mmstack = new MinMaxStack<>();

		mmstack.push(5);
		mmstack.push(3);
		mmstack.push(6);
		mmstack.push(4);
		mmstack.push(1);

		System.out.println("Should be 1: " + mmstack.getMin());
		System.out.println("Should be 6: " + mmstack.getMax());

		mmstack.pop();
		mmstack.pop();
		mmstack.pop();
		mmstack.push(2);

		System.out.println("Should be 2: " + mmstack.getMin());
		System.out.println("Should be 5: " + mmstack.getMax());
	}

	private static void test2() {
		String names[] = { "Isaac Horn", "Timothy Khan", "Erin Roberts", "Bryan Zavala", "Samantha Schmidt",
				"Kevin Burke", "Kim Dixon", "Maureen Hickman", "Charlene Young", "Alan Cook", "Jonathan Wilson",
				"Chad Gibson", "Patrick Peterson", "Tracy Brown", "Ann Barr", "Jesse Lewis", "Sara Marquez",
				"Brady Stevenson", "Donna Gibson", "Megan Shea" };
		MinMaxStack<String> mmstack = new MinMaxStack<>();
		for (String name : names) {
			mmstack.push(name);
		}

		System.out.println("Should print Alan Cook: " + mmstack.getMin());
		System.out.println("Should print Tracy Brown: " + mmstack.getMax());

		for (int i = 0; i < 15; i++) {
			mmstack.pop();
		}

		names = new String[] { "Sydney Montoya", "Marisa Haynes", "James Huff", "Nicholas Rodriguez", "Nicholas Flores",
				"David Mcmillan", "Jon Mann", "Michelle Mcclure", "Lori Weaver", "Sean Watson", "Valerie Williams",
				"Melody Alexander", "Katrina Cruz", "Stacey Williams", "Diana Trujillo", "Timothy Murray",
				"Susan Sullivan", "Madison Brown", "Joshua Harris", "Wendy Salazar" };
		for (String name : names) {
			mmstack.push(name);
		}
		
		System.out.println("Should print Bryan Zavala: " + mmstack.getMin());
		System.out.println("Should print Wendy Salazar: " + mmstack.getMax());
	}
	
	@SuppressWarnings("rawtypes")
	private static void test3() {
		MinMaxStack mmstack = new MinMaxStack();
		System.out.println("getMin Should throw EmptyCollectionException");
		try {
			mmstack.getMin();
			System.out.println("\tFailed");
		} catch(EmptyCollectionException e) {
			System.out.println("\tPassed");
		} catch(Exception e) {
			System.out.println("\tFailed");
		}
		
		System.out.println("getMax Should throw EmptyCollectionException");
		try {
			mmstack.getMax();
			System.out.println("\tFailed");
		} catch(EmptyCollectionException e) {
			System.out.println("\tPassed");
		} catch(Exception e) {
			System.out.println("\tFailed");
		}
	}

	public static void main(String[] args) {
		System.out.println("------------TEST 1-----------");
		test1();
		System.out.println();
		System.out.println("------------TEST 2-----------");
		test2();
		System.out.println();
		System.out.println("------------TEST 3-----------");
		test3();
	}

}
