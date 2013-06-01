import java.util.*;

public class ch2_1 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.appendToTail(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(3);
		n.print();
		removeDuplicates2(n);
		n.print();
	}

	public static void removeDuplicates(Node n) {
		if (n == null)
			return;
		HashSet<Integer> s = new HashSet<Integer>();
		s.add(n.data);
		while (n.next != null) {
			if (s.contains(n.next.data)) {
				n.next = n.next.next;
			}
			else {
				s.add(n.next.data);
				n = n.next;	
			}
		}
	}

	//no buffers
	public static void removeDuplicates2(Node n) {
		for (Node i = n; i != null; i = i.next) {
			Node j = i;
			while (j.next != null) {
				if (j.next.data == i.data) {
					j.next = j.next.next;
				}
				else {
					j = j.next;
				}
			}
		}
	}

}
