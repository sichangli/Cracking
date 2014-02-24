import java.util.*;

public class ch9_1 {

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
		System.out.println(climbStairs2(3));				
	}

	public static int climbStairs(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
	}

	// dp
	public static int climbStairs2(int n) {
		int[] result = new int[n + 1];
		result[0] = 1;

		for (int i = 1; i <= n; i++) {
			int one = i >= 1 ? result[i - 1] : 0;
			int two = i >= 2 ? result[i - 2] : 0;
			int three = i >= 3 ? result[i - 3] : 0;
			result[i] = one + two + three;
		}
		return result[n];
	}
}