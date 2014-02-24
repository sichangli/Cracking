import java.util.*;

public class ch9_6 {

	public static void main(String[] args) {
		ArrayList<String> ps = parentheses(3);
		for (String p : ps) {
			System.out.println(p);
		}
	}

	public static ArrayList<String> parentheses(int n) {
		ArrayList<String> ps = new ArrayList<String>();
		StringBuilder p = new StringBuilder();
		helper(ps, p, 0, 0, n);
		return ps;

	}

	private static void helper(ArrayList<String> ps, StringBuilder p, int left, int right, int n) {
		if (left == n && right == n) {
			ps.add(p.toString());
			return;
		}

		if (left < n) {
			p.append("(");
			helper(ps, p, left + 1, right, n);
			p.deleteCharAt(p.length() - 1);
		}

		if (left > right) {
			p.append(")");
			helper(ps, p, left, right + 1, n);
			p.deleteCharAt(p.length() - 1);
		}

	}

}