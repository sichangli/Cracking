import java.util.*;

public class ch17_7 {

	public static void main(String[] args) {
		describe(1);
	}

	public static String[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	public static String[] teens = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] tens = new String[]{"Twenty", "Thirty", "Fouty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String[] big = new String[]{"", "Thousand", "Million", " Billion"};

	public static void describe(int n) {
		if (0 == n) {
			System.out.println("Zero");
			return;
		}

		boolean negative = false;
		if (n < 0) {
			negative = true;
			n = -n;
		}

		Stack<String> results = new Stack<String>();
		int c = 0;

		while (n > 0) {
			int h = n % 1000;
			if (0 != h) {
				results.push(big[c]);
				describeHundred(h, results);
			}
			n /= 1000;
			c++;
		}

		if (negative) {
			System.out.print("Negative ");
		}

		while (!results.empty()) {
			String top = results.pop();
			System.out.print(top + " ");
		}

		System.out.println();
	}

	// describe number under 1000
	private static void describeHundred(int n, Stack<String> results) {
		int ten = n % 100;
		if (ten <= 10) {
			results.push(digits[ten]);
		} else if (ten > 10 && ten < 20) {
			results.push(teens[ten - 11]);
		} else {
			results.push(digits[ten % 10]);
			results.push(tens[ten / 10 - 2]);
		}

		if (n / 100 > 0) {
			results.push("Hundred");
			results.push(digits[n / 100]);
		}
	}
}