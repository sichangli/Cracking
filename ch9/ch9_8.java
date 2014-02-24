import java.util.*;

public class ch9_8 {

	public static void main(String[] args) {
		System.out.println(makeChange(25, 25));
		System.out.println(makeChange2(25));
	}

	// recursion
	public static int makeChange(int n, int unit) {
		int nextUnit = 0;
		switch (unit) {
			case 25:
				nextUnit = 10;
				break;
			case 10:
				nextUnit = 5;
				break;
			case 5:
				nextUnit = 1;
				break;
			case 1:
				return 1;
			
		}

		int ways = 0;
		for (int i = 0; i * unit <= n; i++) {
			ways += makeChange(n - i * unit, nextUnit);
		}
		return ways;
	}

	// iterative
	public static int makeChange2(int n) {
		int ways = 0;
		for (int i = 0; i * 25 <= n; i++) {
			int r1 = n - i * 25;
			for (int j = 0; j * 10 <= r1; j++) {
				int r2 = r1 - j * 10;
				for (int k = 0; k * 5 <= r2; k++) {
					int r3 = r2 - k * 5;
					for (int z = 0; z <= r3; z++) {
						int r4 = r3 - z;
						if (r4 == 0)
							ways++;
					}
				}
			}
		}
		return ways;
	}
}