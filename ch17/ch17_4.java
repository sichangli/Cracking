import java.util.*;

public class ch17_4 {

	public static void main(String[] args) {

	}

	// the idea is to check the sign of  a - b, but it will overflow if a is very large and b is negative
	public static int findMax(int a, int b) {
		int sign = sign(a - b);
		int nSign = flip(sign);

		return a * sign + b * nSign;
	}

	// 1 for positive and 0 for negtive
	private static int sign(int n) {
		return flip((n >> 31) & 1);
	}

	private static int flip(int n) {
		return n ^ 1;
	}

	// a - b overflow only when a and b are of different signs
	public static int fineMax2(int a, int b) {
		int c = a - b;

		int aSign = sign(a);
		int bSign = sign(b);
		int cSign = sign(c);

		int useA = aSign ^ bSign;
		int useC = flip(useA);

		int use = aSign * useA + cSign * useC;
		return a * use + b * flip(use);
	}

}