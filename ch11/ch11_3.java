import java.util.*;

public class ch11_3 {

	public static void main(String[] args) {

	}

	// note: can use binary search but also need to check the leftmost and rightmost, not just the middle
	public static int find(int[] arr, int left, int right, int n) {
		if (left > right)
			return -1;

		int middle = (left + right) / 2;

		if (arr[middle] == n) {
			return middle;
		} else if (arr[left] <  arr[middle]) {
			if (arr[left] == n) {
				return left;
			} else if (n > arr[left] && n < arr[middle]) {
				return find(arr, left + 1, middle - 1, n);
			} else {
				return find(arr, middle + 1, right, n);
			}
		} else if (arr[left] > arr[middle]) {
			if (arr[right] == n) {
				return right;
			} else if (n > arr[middle] && n < arr[right]) {
				return find(arr, middle + 1, right - 1, n);
			} else {
				return find(arr, left, middle - 1, n);
			}
		} else {   // arr[left] == arr[middle]
			if (arr[right] != arr[left]) { // left half are all the same, just search right
				return find(arr, middle + 1, right, n);
			} else {  //need to search both sides
				int r = find(arr, left + 1, middle - 1, n);
				return r != -1 ? r : find(arr, middle + 1, right - 1, n);
			}
		}

	}

}