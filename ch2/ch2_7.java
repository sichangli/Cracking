import java.util.*;

public class ch2_7 {

	public static void main(String[] args) {
		Node n = new Node(0);
		n.appendToTail(2);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(3);
		n.appendToTail(2);
		n.appendToTail(2);
		n.appendToTail(0);
		System.out.println(isPalindrome(n));
	}

	public static boolean isPalindrome(Node n) {
		Node slow = n;
		Node fast = n;
		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		//odd number, skip the middle one
		if (fast != null) {
			slow = slow.next;
		}

		while (!stack.empty()) {
			int top = stack.pop();
			if (slow.data != top) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

}
