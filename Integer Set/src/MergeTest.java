
public class MergeTest {
	
	public static void Main(String args[]) {
		System.out.println("hello");
	}
	
	
	public static int[] mergeSort(int[] array) {
		mergeSort(array,new int[array.length], 0, array.length -1);
		return null;
	}
	
	public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
		
		}
		int middle = (leftStart + rightEnd) / 2;
		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle +1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
	}
	
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = (leftEnd +1);
		int size = rightEnd - leftStart +1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			}else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(array, left, temp, index, leftEnd - left +1);
		System.arraycopy(array, right, temp, index, rightEnd - right +1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
}
