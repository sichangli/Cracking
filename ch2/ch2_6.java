import java.util.*;

public class ch2_6 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(5);
		n.next.next.next.next.next = n.next.next;
		System.out.println(findBeginning2(n).data);
	}

	// O(n) space
	public static Node findBeginning(Node n) {
		HashSet<String> s  = new HashSet<String>();
		for (Node i = n; i != null; i = i.next) {
			if (s.contains(i.toString()))
				return i;
			else
				s.add(i.toString());
		}
		return null;
	}

	// no extra space, assume given circular linked list
	public static Node findBeginning2(Node n) {
		Node slow = n;
		Node fast = n;

		while (true) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		slow = n;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

}
