import java.util.*;

public class ch4_6 {

	public static void main(String[] args) {
	
	}

	public static TreeNode nextNode(TreeNode n) {
		if (n == null)
			return null;

		TreeNode next;
		if (n.right != null) {
			next = n.right;
			while (next.left != null) {
				next = next.left;
			} 
		} else {
			next = n.parent;
			while (next != null && n != next.left) {
				n = next;
				next = next.parent;
			}
		}

		return next;
	}

}