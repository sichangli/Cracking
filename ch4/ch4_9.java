import java.util.*;

public class ch4_9 {

	public static void main(String[] args) {
		
	}

	public static void pathSum(TreeNode r, int sum) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		helper(r, sum, arr, 0);
	}

	private static void helper(TreeNode r, int sum, ArrayList<Integer> arr, int level) {
		if (r == null)
			return;

		// if first reaches this level
		if (level == arr.size()) {
			arr.add(r.val);
		} else {
			arr.set(level, r.val);
		}

		printPath(arr, level, sum);

		helper(r.left, sum, arr, level + 1);
		helper(r.right, sum, arr, level + 1);

	}

	private static void printPath(ArrayList<Integer> arr, int level, int sum) {
		int s = 0;
		for (int i = level; i >= 0; i--) {
			s += arr.get(i);
			if (s == sum) {
				printResult(arr, i, level);
			}
		}
	}

	private static void printResult(ArrayList<Integer> arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(arr.get(i) + ' ');
		}
		System.out.println();
	}

}