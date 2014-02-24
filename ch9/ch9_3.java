import java.util.*;

public class ch9_3 {

	public static void main(String[] args) {
	}

	public static int findMagicIndex(int[] arr, int start, int end) {
		if (start > end)
			return -1;

		int middle = (start + end) / 2;
		if (arr[middle] == middle) {
			return middle;
		} else if (arr[middle] > middle) {
			return findMagicIndex(arr, start, middle - 1);
		} else {
			return findMagicIndex(arr, middle + 1, end);
		}
	}

	//follow up: not distinct
	public static int findMagicIndex2(int[] arr, int start, int end) {
		if (start > end)
			return -1;

		int middle = (start + end) / 2;

		if (arr[middle] == middle)
			return middle;


		// can skip some if arr[middle] < middle - 1
		int left = findMagicIndex2(arr, start, Math.min(arr[middle], middle - 1));
		if (left != -1)
			return left;

		// can skip some if arr[middle] > middle + 1
		int right = findMagicIndex2(arr, Math.max(arr[middle], middle + 1), end);
		if (right != -1)
			return right;

		return -1;
	}

}