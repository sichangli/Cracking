import java.util.*;

public class ch17_13 {

	public static void main(String[] args) {
	}

	// the idea is to use recursion to convert on root.node1 and root.node2, then combine
	// return the head of list
	public static BiNode convert(BiNode root) {
		if (root == null)
			return null;

		BiNode leftHead = convert(root.node1);
		BiNode rightHead = convert(root.node2);

		// if left is not null, find the end of left and combine
		if (null != leftHead) {
			BiNode leftTail = leftHead;
			while (leftTail.node2 != null) {
				leftTail = leftTail.node2;
			}
			leftTail.node2 = root;
			root.node1 = leftTail;
		}

		// if right is not null, combine
		if (null != rightHead) {		
			root.node2 = rightHead;
			rightHead.node1 = root;
		}


		// return head of new list: the root of the head of left list
		return null == leftHead ? root : leftHead;
	}

	// keep track of the head of tail using additional data structure, can save time to find tail
	public static NodePair convert2(BiNode root) {
		if (root == null)
			return null;

		NodePair left = convert2(root.node1);
		NodePair right = convert2(root.node2);

		if (left != null) {
			left.tail.node2 = root;
			root.node1 = left.tail;
		}

		if (right != null) {
			right.head.node1 = root;
			root.node2 = right.head;
		}

		NodePair result = new NodePair();
		result.head = left == null ? root : left.head;
		result.tail = right == null ? root : right.tail;

		return result;
	} 
}

class BiNode {
	public BiNode node1, node2;
	public int data;
}

class NodePair {
	BiNode head;
	BiNode tail;
}