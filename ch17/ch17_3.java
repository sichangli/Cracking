import java.util.*;

public class ch17_3 {

	public static void main(String[] args) {
		System.out.println("10: " + count(10));
		System.out.println("25: " + count2(25));

	}


	public static int count(int n) {
		int count = 0;
		for (int i = 5; i <= n; i++) {
			count += count5s(i);
		}
		return count;
	}

	private static int count5s(int n) {
		int count = 0;

		while (0 == n % 5) {
			count++;
			n /= 5;
		}
		return count;
	}

	// the idea is to count numbers of 5s, 25s, 125s.....
	public static int count2(int n) {
		int count = 0;

		for (int i = 5; n / i > 0; i *= 5) {
			count += n / i;
		}

		return count;
	}
}