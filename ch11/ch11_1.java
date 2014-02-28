import java.util.*;

public class ch11_1 {

	public static void main(String[] args) {

	}

	public static void merge(int[] a, int[] b, int aSize) {
		// shift a to right by length of b
		for (int i = aSize - 1; i >= 0; i--) {
			a[i + b.length] = a[i];
		}

		int aStart = b.length;
		int aEnd = aSize - 1 + b.length;
		int bStart = 0;
		int bEnd = b.length - 1;

		int i = 0;
		while (aStart <= aEnd && bStart <= bEnd) {
			if (a[aStart] <= b[bStart]) {
				a[i++] = a[aStart++];
			} else {
				a[i++] = b[bStart++];
			}
		}

		while (aStart <= aEnd) {
			a[i++] = a[aStart++];
		}

		while (bStart <= bEnd) {
			a[i++] = b[bStart++];
		}

	}

	// merge from the back
	public static void merge2(int[] a, int[] b, int aSize) {
		int aEnd = aSize - 1;
		int bEnd = b.length - 1;
		int newEnd = aSize + b.length - 1;

		while (aEnd >= 0 && bEnd >= 0) {
			if (a[aEnd] > b[bEnd]) {
				a[newEnd--] = a[aEnd--];
			} else {
				a[newEnd--] = b[bEnd--];
			}
		}

		// the rest, only need to copy b, if a has left, it's already there.
		while (bEnd >= 0) {
			a[newEnd--] = b[bEnd--];
		}
	}
}