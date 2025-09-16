import java.util.Arrays;

public class Test {
    public static void main(String args[]) {
    	
    //creating two new arrays - One size of 35 one size of 65
	int arr1[] = new int[35];
	int arr2[] = new int[65];
	
	
	//Filling first array with random numbers from 0-100
	IntArrayOperations.randomFillArray(arr1, 0, 100);
	//Printing out the Array
	System.out.println(Arrays.toString(arr1));

	//Filling second array with random numbers from 50-150
	IntArrayOperations.randomFillArray(arr2, 50, 150);
	//Printing out the Array
	System.out.println(Arrays.toString(arr2));
	
	
	//calling Integer set to remove duplicates from array 1 and 2 and sort
	IntegerSet iS1 = new IntegerSet(arr1);
	IntegerSet iS2 = new IntegerSet(arr2);
	
	//print out the product that was stored in iS1 and iS2
	System.out.println("iS1: " + iS1);
	System.out.println("iS2: " + iS2);
	
	//creates a number to search for in array
	int toCheck = 15;
	
	//Prints iS1 array then looks to see if 15 is in the iS1 array
	System.out.println(String.format("iS1.contains(%d): ", toCheck) + iS1.contains(toCheck));
	
	//takes iS1 and iS2 and runs intersection (Should only so numbers in common with both arrays)
	System.out.println(iS1.intersection(iS2));
	//takes iS1 and iS2 and joins them together was one array
	System.out.println(iS1.union(iS2));
	
    }
}
