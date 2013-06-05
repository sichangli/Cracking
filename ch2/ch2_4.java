public class ch2_4 {
	
	public static void main(String[] args) {
		Node n = new Node(100);
		n.appendToTail(50);
		n.appendToTail(50);
		n.appendToTail(50);
		n.appendToTail(60);
		n.appendToTail(70);
		n.appendToTail(20);
		n.appendToTail(30);
		n.print();
		Node nn = partition4(n, 50);
		nn.print();
	}

	public static Node partition(Node n, int x) {
		if (n == null) {
			System.out.println("Cannot be null!");
			System.exit(1);
		}
		Node result = new Node(n.data);
		for (Node i = n.next; i != null; i = i.next) {
			if (i.data < x) {
				Node newNode = new Node(i.data);	
				newNode.next = result;
				result = newNode;
			}
			else {
				result.appendToTail(i.data);
			}
		}
		return result;
	}

	//in place
	public static Node partition2(Node n, int x) {
		Node next = n;
		Node first1 = null;
		Node last1 = null;
		Node last2 = null;
		Node current = null;
		while (next != null) {
			current = next; 
			next = next.next;	
			if (current.data < x) {
				if (last1 == null) {
					if (last2 == null)
						current.next = null;
					else
						current.next = n;
					last1 = current;
					first1 = current;
				}
				else {
					current.next = last1.next;
					last1.next = current;
					last1 = last1.next;
				}
			}
			else {
				current.next = null;
				if (last2 == null) {
					if (last1 != null)
						last1.next = current;
					last2 = current;
				}
				else {
					last2.next = current;
					last2 = last2.next;
				}
			}
		}
		if (last1 != null)
			return first1;
		else
			return n;
	}
	
	public static Node partition3(Node n, int x) {
		Node next = n;
		Node first1 = null;
		Node last1 = null;
		Node first2 = null;
		Node last2 = null;
		Node current = null;
		while (next != null) {
			current = next;
			next = next.next;
			current.next = null;
			if (current.data < x) {
				if (first1 == null) {
					first1 = current;
					last1 = current;
				}
				else {
					last1.next = current;
					last1 = current;
				}
			}
			else {
				if (first2 == null) {
					first2 = current;
					last2 = current;
				}
				else {
					last2.next = current;
					last2 = current;
				}
			}
		}
		if (first1 == null)
			return first2;
		last1.next = first2;
		return first1;
	}

	public static Node partition4(Node n, int x) {
		Node next = n;
		Node first1 = null;
		Node first2 = null;
		Node current = null;
		while (next != null) {
			current = next;
			next = next.next;
			if (current.data < x) {
				if (first1 == null) {
					first1 = current;
					current.next = null;
				}
				else {
					current.next = first1;
					first1 = current;
				}
			}
			else {
				if (first2 == null) {
					first2 = current;
					current.next = null;
				}
				else {
					current.next = first2;
					first2 = current;
				}
			}
		}
		if (first1 == null)
			return first2;
		Node last1 = first1;
		while (last1.next != null)
			last1 = last1.next;
		last1.next = first2;
		return first1;
	}
}
