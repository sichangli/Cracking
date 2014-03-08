import java.util.*;

public class ch17_11 {

	public static void main(String[] args) {
	}

	public static int rand7() {
		while (true) {
			int r5 = rand5() * 5 + rand5();
			if (r5 < 21) return r5 % 7;
		}
	}

	private static int rand5() {
		Random r = new Random();
		return r.nextInt(5);
	}
}