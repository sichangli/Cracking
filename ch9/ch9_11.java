import java.util.*;

public class ch9_11 {

	public static void main(String[] args) {

	}

	public static int evaluate(String exp, boolean result) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return f(exp, result, 0, exp.length() - 1, map);
	}

	private static int f(String exp, boolean result, int s, int e, HashMap<String, Integer> map) {
		String key = "" + s + result + e;
		if (map.containsKey(key)) {
			return map.get(key);
		}

		if (s == e) {
			if (exp.charAt(s) == '1' && result) {
				return 1;
			} else if (exp.charAt(s) == '0' && !result) {
				return 1;
			} else {
				return 0;
			}
		}

		int count = 0;

		if (result) {
			for (int i = s + 1; i <= e; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += f(exp, true, s, i - 1, map) * f(exp, true, i + 1, e, map);
				} else if (op == '|') {
					count += f(exp, true, s, i - 1, map) * f(exp, true, i + 1, e, map);
					count += f(exp, true, s, i - 1, map) * f(exp, false, i + 1, e, map);
					count += f(exp, false, s, i - 1, map) * f(exp, true, i + 1, e, map);
				} else if (op == '^') {
					count += f(exp, true, s, i - 1, map) * f(exp, false, i + 1, e, map);
					count += f(exp, false, s, i - 1, map) * f(exp, true, i + 1, e, map);
				}
			}
		} else {
			for (int i = s + 1; i <= e; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += f(exp, false, s, i - 1, map) * f(exp, false, i + 1, e, map);
					count += f(exp, true, s, i - 1, map) * f(exp, false, i + 1, e, map);
					count += f(exp, false, s, i - 1, map) * f(exp, true, i + 1, e, map);
				} else if (op == '|') {
					count += f(exp, false, s, i - 1, map) * f(exp, false, i + 1, e, map);
				} else if (op == '^') {
					count += f(exp, true, s, i - 1, map) * f(exp, true, i + 1, e, map);
					count += f(exp, false, s, i - 1, map) * f(exp, false, i + 1, e, map);
				}
			}
		}

		map.put(key, count);
		return count;
	}



}