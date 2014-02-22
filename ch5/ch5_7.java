import java.util.*;

public class ch5_7 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		arr.add(2);
		arr.add(3);

		System.out.println(findMissing(arr));
									
	}

	public static int findMissing(ArrayList<Integer> arr) {
		int result = 0;

		for (int i = 0; i <= 31; i++) {
			ArrayList<Integer> oneBits = new ArrayList<Integer>();
			ArrayList<Integer> zeroBits = new ArrayList<Integer>();

			for (Integer a : arr) {
				if (fetch(a, i) == 1) {
					oneBits.add(a);
				} else {
					zeroBits.add(a);
				}
			}

			if (zeroBits.size() <= oneBits.size()) {
				arr = zeroBits;
			} else {
				result |= (1 << i);
				arr = oneBits;
			}
		}

		return result;

	}

	// fetch the jth bit of n
	private static int fetch(int n, int j) {
		if ((n & (1 << j)) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}