import java.util.*;

public class ch17_8 {

	public static void main(String[] args) {
		int[] arr = new int[]{-3, -1, -4};
		System.out.println(seq(arr));
	}

	public static int seq(int[] arr) {
		int start = 0;
		int end = 0;
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		while (end < arr.length) {
			currentSum += arr[end];

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
				start = end + 1;
			}

			end++;
		}

		return maxSum;
	}

}