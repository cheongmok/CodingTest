package Sort;

public class SortTest {

	static final boolean ASCENDING = true;
	static final boolean DESCENDING = false;
	
	private static void printArr(int[] arr) {
		for (int index = 0; index < arr.length; ++index ) {
			System.out.print(arr[index] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] testArr = {8, 3, 7, 5, 4, 2};
		
		System.out.print("Before sort - ");
		printArr(testArr);
		
		// Sorting Test Code Here
		// Bubble Sort
		BubbleSort bs = new BubbleSort();
		bs.sort(testArr);
		
		System.out.print("After sort - ");
		printArr(testArr);
	}

}
