import java.util.*;

public class ch5_3 {

	public static void main(String[] args) {
		print(2);
			
	}

	// brute force
	public static void print(int n) {
		System.out.println("n: " + n);
		int c1 = countOnes(n);
		
		int smallest = n - 1;
		int largest = n + 1;

		while (countOnes(smallest) != c1) {
			smallest--;
		}

		while (countOnes(largest) != c1) {
			largest++;
		}

		System.out.println("smallest: " + smallest);
		System.out.println("largest: " + largest);
	}

	private static int countOnes(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	} 

	// bit manupilation, the idea is to flip a 0 to a 1 and flip a 1 to 0
	public static void printNext(int n) {
		if (n == 0) {
			System.out.println("Error");
			return;
		}

		int c0 = 0;
		int c1 = 0;
		int temp = n;

		//count trailing 0s
		while ((temp & 1) == 0) {
			c0++;
			temp >>= 1;
		}

		// count following 1s
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		// error checking
		if (c0 + c1 == 31) {
			System.out.println("Error");
			return;
		}

		int p = c0 + c1;

		// flip p
		n |= (1 << p);
		// clear following bits
		n &= (~0 << p);
		// set c1 - 1 1s
		n |= (1 << (c1 - 1)) - 1;
		System.out.println("Next: " + n);
	}

	public static void printNext2(int n) {
		if (n == 0) {
			System.out.println("Error");
			return;
		}

		int c0 = 0;
		int c1 = 0;
		int temp = n;

		//count trailing 0s
		while ((temp & 1) == 0) {
			c0++;
			temp >>= 1;
		}

		// count following 1s
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		// error checking
		if (c0 + c1 == 31) {
			System.out.println("Error");
			return;
		}


		int next = n + (1 << c0) + (1 << (c1 - 1)) - 1;
		
		System.out.println("Next: " + next);
	}

	public static void printPrev(int n) {
		if (n == 0) {
			System.out.println("Error");
			return;
		}

		int c1 = 0;
		int c0 = 0;
		int temp = n;

		// count trailing 1s
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		// if has only trailing 1s
		if (temp == 0) {
			System.out.println("Error");
			return;
		}

		//count following 0s
		while ((temp & 0) == 0) {
			c0++;
			temp >>= 1;
		}

		int p = c0 + c1;

		n &= (~0 << (p + 1));
		int mask = (1 << (c1 + 1)) - 1;
		n |= (mask << (c0 - 1));

		System.out.println("Prev: " + n);

	}

	public static void printPrev2(int n) {
		if (n == 0) {
			System.out.println("Error");
			return;
		}

		int c1 = 0;
		int c0 = 0;
		int temp = n;

		// count trailing 1s
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		// if has only trailing 1s
		if (temp == 0) {
			System.out.println("Error");
			return;
		}

		//count following 0s
		while ((temp & 0) == 0) {
			c0++;
			temp >>= 1;
		}

		int prev = n - (1 << c1) - ((1 << (c0 - 1)) - 1);

		System.out.println("Prev: " + prev);

	}

}