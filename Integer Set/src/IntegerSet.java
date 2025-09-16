import java.lang.reflect.Array;

public class IntegerSet {

	// The array that represents the set.
	private final int set[];

	/**
	 * The constructor for IntegerSet. When an IntegerSet is created it must be
	 * initialized with an integer array. The set will then pull out the duplicated
	 * items and keep the unique integers.
	 * 
	 * @param arr The array to create the set from.
	 */
	public IntegerSet(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("The array must not be null");
		}
		//int[] tempArray =  new int[arr.length];
		//create empty array of same size as arr, call it temparray
		set = uniqueElements(arr); // Sort and unique are done in uniqueElements. Calls in test assume this has
									// already been done.
	}
	/**
	 * This is the size of the set which, in this case, is just the length of the
	 * array.
	 * 
	 * @return The length of the set.
	 */
	public int magnitude() {
		return set.length;
	}

	/**
	 * This method is private and is used to help set up the set array. An integer
	 * set is one in which the elements are unique (no duplicates) and are sorted.
	 * 
	 * @param arr The array that will be used to retrieve the unique elements from.
	 * @return The new integer array that contains the unique elements from arr.
	 */
	private int[] uniqueElements(int[]arr){
		int[] tempArray = new int [arr.length];
		mergeSort(arr, tempArray, 0, arr.length -1);
		return arr;
		//return null;
	}
	

	/**
	 * This method returns whether or not value is located in the set. If the value
	 * is in the set then return true otherwise return false. <br />
	 * Example:
	 * 
	 * <pre>
	 * 		IntegerSet iS1 = new IntegerSet([1,2,3,4]); 
	 * 		iS1.contains(3); //returns true
	 * 		iS2.contains(6); //returns false
	 * </pre>
	 * 
	 * @param value The integer to look for.
	 * @return True if value is located in the set otherwise false.
	 */
	public boolean contains(int value) {

//    	if(value =  ) {
//    		
//    	}else

		return false;
	}

	/**
	 * A union of two sets is a new set that contains all elements from both sets.
	 * This method takes another set and unions it with the set that calls this
	 * method. A new IntegerSet is returned that contains the union of both
	 * sets.<br />
	 * Example:
	 * 
	 * <pre>
	 * 		IntegerSet is1 = new IntegerSet([1, 2, 3, 4]); 
	 * 		IntegerSet is2 = new IntegerSet([3, 4, 5, 6, 7, 8]);
	 * 		is1.union(is2) //returns new IntegerSet([1, 2, 3, 4, 5, 6, 7, 8]);
	 * </pre>
	 * 
	 * @param otherSet The set to be unioned with.
	 * @return A new IntegerSet that is the union of the calling set with the
	 *         otherSet.
	 */
	public IntegerSet union(IntegerSet otherSet) {

		return null;
	}

	/**
	 * The intersection of two sets is a new set that contains elements that occur
	 * in both sets. This method takes another set and intersects it with the set
	 * that calls this method. A new IntegerSet is returned that contains the
	 * intersection of the two sets. <br />
	 * Example:
	 * 
	 * <pre>
	 * 		IntegerSet is1 = new IntegerSet([1,2,3,4]);
	 * 		IntegerSet is2 = new IntegerSet([3,4,5]);
	 * 		is1.intersection(is2) //returns new IntegerSet([3, 4]);
	 * </pre>
	 * 
	 * @param otherSet The set to be intersected with.
	 * @return A new IntegerSet that is the intersection of the calling set with the
	 *         otherSet.
	 */
	public IntegerSet intersection(IntegerSet otherSet) {
		return null;
	}

	/**
	 * Returns a string representation of an IntegerSet type. The returned string
	 * will have the following structure.
	 * 
	 * set{ elements in the set separated by a comma }.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("set{ ");
		for (int i = 0; i < set.length; i++) {
			sb.append(set[i]);
			if (i < set.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(" }");
		return sb.toString();
	}
	
	public static void sort(int arr[]) {
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	
	// method that sorts and calls merging method
	private static void mergeSort(int arr[], int tempArray[], int first, int last) {
		// Base Case
		if (first >= last) {
			return;
		}

		// Find the Mid Index for splitting into separate arrays
		int mid = first + (last - first) / 2;

		// recursive calls to sort the two sections of the array

		mergeSort(arr, tempArray, first, mid);
		
		mergeSort(arr, tempArray, mid + 1, last);

		// Call to merge the sorted halves back together
		merge(arr, tempArray, first, mid, last);
	}

	// Method that does the merging
	private static void merge(int arr[], int tempArray[], int first, int mid, int last) {

		// Create Variables
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;
		int index = 0;

		// while loop that does the merging
		while (beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2) {
			
			//(arr[beginHalf1] <= arr[endHalf2]) //CANT COMPARE OBJECTS NEED TO FIND ANOTHER WAY
				
			// store the result in a variable
			// Use stored result res to determine if the item at arr[beginHalf1] is less
			// than or equal to the item at arr[beginHalf2].
			int res = ((Comparable) arr[beginHalf1]).compareTo(arr[beginHalf2]);
			
			if (res <= 0) {
				
				tempArray[index] = arr[beginHalf1];
				index++;
				beginHalf1 ++;
				
			}else {
				
				tempArray[index] = arr[beginHalf2];
				beginHalf2++;
				index ++;
			}
		}

		// we need to copy the remaining elements from the other sub array into
		// tempArray.
		while (beginHalf1 <= endHalf1) {
			
			tempArray[index] = arr[beginHalf1];
			index++;
			beginHalf1++;
		}

		while (beginHalf2 <= endHalf2) {
			
			tempArray[index] = arr[beginHalf2];
			index++;
			beginHalf2++;
		}

		// copy the elements from 0 up to (last - first) in tempArray into original array.
		for (int i = 0, j = first; i <= (last - first); i++, j++) {
			
			arr[j] = tempArray[i];
		}

	}
	
	

}

