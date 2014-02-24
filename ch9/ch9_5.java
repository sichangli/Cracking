import java.util.*;

public class ch9_5 {

	public static void main(String[] args) {
		ArrayList<String> p = permutations("abc");
		for (String s : p) {
			System.out.println(s);
		}
	}


	public static ArrayList<String> permutations(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		StringBuilder permutation = new StringBuilder();
		HashSet<Integer> visited = new HashSet<Integer>();
		helper(s, permutation, permutations, visited);

		return permutations;
	}

	private static void helper(String s, StringBuilder permutation, ArrayList<String> permutations, HashSet<Integer> visited) {
		if (permutation.length() == s.length()) {
			permutations.add(permutation.toString());
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			if (visited.contains(i)) {
				continue;
			}
			permutation.append(s.charAt(i));
			visited.add(i);
			helper(s, permutation, permutations, visited);
			permutation.deleteCharAt(permutation.length() - 1);
			visited.remove(i);
		}
	}
}