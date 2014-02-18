import java.util.*;

public class ch4_4 {

	public static void main(String[] args) {
		TreeNode r = new TreeNode(0);
		r.left = new TreeNode(1);
		r.right = new TreeNode(2);
		LinkedList<LinkedList<TreeNode>> ll = level2(r);
		for (LinkedList<TreeNode> l : ll) {
			for (TreeNode n : l) {
				System.out.print(n.val + " ");
			}
			System.out.println();
		}
	}

	// using bfs
	public static LinkedList<LinkedList<TreeNode>> level(TreeNode r) {
		LinkedList<LinkedList<TreeNode>> ll = new LinkedList<LinkedList<TreeNode>>();
		if (r == null)
			return ll;

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		q.add(r);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode h = q.poll();
			if (h != null) {
				if (h.left != null) q.add(h.left);
				if (h.right != null) q.add(h.right);
				l.add(h);
			} else {
				ll.add(l);
				if (q.isEmpty()) {
					break;
				}
				l = new LinkedList<TreeNode>();
				q.add(null);
			}
		}
		return ll;
	}

	public static LinkedList<LinkedList<TreeNode>> level2(TreeNode r) {
		LinkedList<LinkedList<TreeNode>> ll = new LinkedList<LinkedList<TreeNode>>();
		if (r == null)
			return ll;

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(r);
		while (!current.isEmpty()) {
			ll.add(current);
			LinkedList<TreeNode> previous = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode n : previous) {
				if (n.left != null) current.add(n.left);
				if (n.right != null) current.add(n.right);
			}
		}
		return ll;
	}

}
