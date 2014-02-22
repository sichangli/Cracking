import java.util.*;

public class ch5_5 {

	public static void main(String[] args) {
		System.out.println(convert(31, 14));
					
	}

	public static int convert(int a, int b) {
		int c = a ^ b;
		return countOnes(c);
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

}