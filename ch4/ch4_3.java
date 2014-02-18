import java.util.*;

public class ch4_3 {

	public static void main(String[] args) {
		
	}

	public static TreeNode BST(int[] arr) {
		return BSTHelper(arr, 0, arr.length - 1);
	}

	private static TreeNode BSTHelper(int[] arr, int s, int e) {
		if (s > e)
			return null;

		int m = (s + e) / 2;
		TreeNode r = new TreeNode(arr[m]);
		r.left = BSTHelper(arr, s, m - 1);
		r.right = BSTHelper(arr, m + 1, e);
		return r;
	}
}