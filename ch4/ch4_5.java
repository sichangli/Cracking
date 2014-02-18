import java.util.*;

public class ch4_5 {

	public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(3);
		r.right = new TreeNode(2);
		System.out.println(isBST(r));
		System.out.println(isBST2(r));
	}

	// in order traversal
	public static boolean isBST(TreeNode r) {
		ArrayList<TreeNode> a = new ArrayList<TreeNode>();
		inOrder(r, a);
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i - 1).val > a.get(i).val)
				return false;
		}
		return true;

	}

	private static void inOrder(TreeNode r, ArrayList<TreeNode> a) {
		if (r == null)
			return;

		inOrder(r.left, a);
		a.add(r);
		inOrder(r.right, a);	
	}

	// 
	public static boolean isBST2(TreeNode r) {
		return helper(r, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean helper(TreeNode r, int min, int max) {
		if (r == null)
			return true;

		if (r.val > min && r.val <= max) {
			return helper(r.left, min, r.val) && helper(r.right, r.val, max);
		} else {
			return false;
		}

	}
}