import java.util.*;

public class ch9_4 {

	public static void main(String[] args) {
	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {

		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();
		subsets.add(subset);
		helper(S, 0, subset, subsets);
		return subsets;

	}

	public static void helper(int[] S, int start, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> subsets) {
		for (int i = start; i < S.length; i++) {
			subset.add(S[i]);
			subsets.add(new ArrayList<Integer>(subset));
			helper(S, start + 1, subset, subsets);
			subset.remove(subset.size() - 1);
		}
	}
}