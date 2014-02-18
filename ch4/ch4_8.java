import java.util.*;

public class ch4_8 {

	public static void main(String[] args) {
		
	}

	// check whether t2 is subtree of t1
	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;

		if (t1 == null)
			return false;

		if (t1.val == t2.val && helper(t1, t2)) {
			return true;
		}

		return isSubtree(t1.left, t2) || isSubtree(t1.right, t2); 
	}

	private static boolean helper(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;

		if (t1 == null || t2 == null)
			return false;

		if (t1.val != t2.val)
			return false;

		return helper(t1.left, t2.left) && helper(t1.right, t2.right);
	}

}