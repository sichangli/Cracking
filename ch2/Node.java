public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = end;
	}

	public Node appendToHead(int d) {
		Node h = new Node(d);
		h.next = this;
		return h;
	}

	public void print() {
		Node n = this;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public int length() {
		int len = 0;
		Node n = this;
		while (n != null) {
			len++;
			n = n.next;
		}
		return len;
	}
}
