import java.util.*;

public class ch11_5 {

	public static void main(String[] args) {

	}

	public static int findWraper(String[] ss, String s) {
		if (null == ss || s == null || s.isEmpty())
			return -1;

		return find(ss, s, 0, s.length() - 1);
	}


	public static int find(String[] ss, String s, int left, int right) {
		if (left > right)
			return -1;

		int middle = (left + right) / 2;


		// find the nearest non-empty string
		if (ss[middle].isEmpty()) {
			int lm = middle - 1;
			int rm = middle + 1;
			while (true) {
				if (lm < left && rm > right) {
					return -1;
				}
				if (lm >= left) {
					if (ss[lm].isEmpty()) {
						lm--;
					} else {
						middle = lm;
						break;
					}
				}
				if (rm <= right) {
					if (ss[rm].isEmpty()) {
						rm++;
					} else {
						middle = rm;
						break;
					}
				}
			}
		}

		if (s.equals(ss[middle])) {
			return middle;
		} else if (s.compareTo(ss[middle]) < 0) {
			return find(ss, s, left, middle - 1);
		} else {
			return find(ss, s, middle + 1, right);
		}

	}	
}