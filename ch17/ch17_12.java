import java.util.*;

public class ch17_12 {

	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, 5, 7, 1, 6};
		twoSum(arr, 7);
	}

	public static void twoSum(int[] arr, int sum) {
		if (null == arr) {
			return;
		}

		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int s = arr[start] + arr[end];
			if (s == sum) {
				System.out.println(arr[start] + " " + arr[end]);
				start++;
				end--;
			} else if (s < sum) {
				start++;
			} else {
				end--;
			}
		}

	}

}