import java.util.*;

public class ch5_1 {

	public static void main(String[] args) {
	
	}

	public static int fit(int n, int m, int i, int j) {
		n = clearBits(n, i, j);

		return (m << i) | n;
	}

	private static int clearBits(int n, int i, int j) {
		for (int t = i; t <= j; t++) {
			n = clearBit(n, t);
		}
		return n;
	}

	private static int clearBit(int n, int t) {
		return ~(1 << t) & n;
	}

	// another way to clear bits
	private static int clearBits2(int n, int i, int j) {
		int allOnes = ~0;

		// 11100000
		int leftOnes = allOnes << (j + 1);
		// 00000011
		int rightOnes = (1 << i) - 1;
		// 11100011
		int mask = leftOnes | rightOnes;

		return n & mask;
	}
}