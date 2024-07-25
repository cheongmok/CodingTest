package Sort;

public class BubbleSort {
	public void sort(int[] arr, boolean ascending) {
		if (ascending) {
			bubbleSortAscending(arr);
		} else {
			bubbleSortDescending(arr);
		}

	}
	
	public void sort(int[] arr) {
		sort(arr, true);
	}
	
	private static void bubbleSortAscending(int[] arr)
	{
		for(int round = 1; round < arr.length; ++round) {
			for (int index = 0; index < arr.length - round; ++index) {
				if (arr[index] > arr[index + 1]) {
					swap(arr, index, index + 1);
				}
			}
		}
	}
	
	private static void bubbleSortDescending(int[] arr)
	{
		for(int round = 1; round < arr.length; ++round) {
			for (int index = 0; index < arr.length - round; ++index) {
				if (arr[index] < arr[index + 1]) {
					swap(arr, index, index + 1);
				}
			}
		}
	}
	
	private static void swap(int[] arr, int indexA, int indexB)	{
		int temp = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = temp;
	}
}
