import java.util.*;

public class ch17_6 {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		sort(arr);

	}


	public static void sort(int[] arr) {
		// find the end of inscreasing numbers from the start
		int leftEnd = 0;
		while (leftEnd < arr.length - 1 && arr[leftEnd] <= arr[leftEnd + 1]) {
			leftEnd++;
		}

		// if is alreay sorted
		if (leftEnd == arr.length - 1) {
			System.out.println("Already sorted!");
			return;
		}

		// find the start of decreasing numbers from the end
		int rightStart = arr.length - 1;
		while (rightStart > 0 && arr[rightStart - 1] <= arr[rightStart]) {
			rightStart--;
		}

		// find the min from leftEnd + 1 to the end of array, not just from the middle
		// for example  {7, 8, 10, 9, 10, 0, 1}.  find the min only from the middle won't work
		int minPos = leftEnd + 1;
		for (int i = leftEnd + 1; i < arr.length; i++) {
			if (arr[i] < arr[minPos]) {
				minPos = i;
			}
		}

		// find the max from the begining of the array to rightStart - 1
		int maxPos = 0;
		for (int i = 0; i < rightStart; i++) {
			if (arr[i] > arr[maxPos]) {
				maxPos = i;
			}
		}

		// shrink both of the sides
		while (leftEnd > 0 && arr[leftEnd - 1] > arr[minPos]) {
			leftEnd--;
		}

		while (rightStart < arr.length - 1 && arr[rightStart + 1] < arr[maxPos]) {
			rightStart++;
		}

		System.out.println("m: " + leftEnd + " n: " + rightStart);
	}
}
