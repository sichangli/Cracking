import java.util.*;

public class ch11_8 {

	public static void main(String[] args) {

	}

}

class RankNode {

	private Node root;

	public void track(int x) {
		if (null == root) {
			root = new Node(x, null, null, 0);
			return;
		}

		Node current = root;

		while (true) {
			if (x <= current.data) {
				current.leftSize++;
				// if find the position to insert
				if (null == current.left) {
					current.left = new Node(x, null, null, 0);
					break;
				} else {
					current = current.left;
				}
			} else {
				if (null == current.right) {
					current.right = new Node(x, null, null, 0);
					break;
				} else {
					current = current.right;
				}
			}
		}
	}

	public int getRankOfNumber(int x) {
		if (null == root)
			return -1;

		int count = 0;
		Node current = root;
		while (true) {
			// found
			if (x == current.data) {
				count += current.leftSize;
				break;
			} else if (x < current.data) {
				if (null == current.left) {
					return -1;
				} else {
					current = current.left;
				}

			} else {
				if (null == current.right) {
					return -1;
				} else {
					current = current.right;
					// update the count
					count += current.leftSize + 1;
				}
			}
		}

		return count;
	}

	// the idea is to maintain an extra field to keep track of the size of the left subtree
	 private class Node {
	 	Node left;
	 	Node right;
	 	int data;
	 	int leftSize;

	 	public Node(int d, Node l, Node r, int ls) {
	 		data = d;
	 		left = l;
	 		right = r;
	 		leftSize = ls;
	 	}
	 }
}