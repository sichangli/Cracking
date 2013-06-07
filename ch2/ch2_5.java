public class ch2_5 {

	public static void main(String[] args) {
		Node a = new Node(7);
		a.appendToTail(1);
		a.appendToTail(6);
		Node b = new Node(5);
		b.appendToTail(9);
		b.appendToTail(3);
		Node c = sum(a, b);
		a.print();
		b.print();
		c.print();
		System.out.println("---------FOLLOW UP---------------");
		a = new Node(6);
		a.appendToTail(1);
		a.appendToTail(7);
		b = new Node(3);
		b.appendToTail(9);
		b.appendToTail(5);
		c = sum3(a, b);
		a.print();
		b.print();
		c.print();
	}

	//should check the last carry
	public static Node sum(Node a, Node b) {
		Node h = null;
		Node t = null;
		int mod = 0;
		while (a != null || b != null) {
			int result = 0;
			if (a != null) {
				result += a.data;
				a = a.next;
			}
			if (b != null) {
				result += b.data;
				b = b.next;
			}
			
			Node n = new Node((result + mod) % 10);
			if (h == null) {
				h = n;
				t = n;
			}
			else {
				t.next = n;
				t = n;
			}
			
			mod = (result + mod) / 10;
		}
		if (mod > 0) {
			Node cn = new Node(1);
			t.next = cn;
		}
		return h;
	}

	//follow up
	//assume same length
	static int mod = 0;
	public static Node sum2Rec(Node a, Node b) {
		if (a == null && b == null)
			return null;
		
		int result = 0;
		if (a != null) {
			result += a.data;
			a = a.next;
		}
		if (b != null) {
			result += b.data;
			b = b.next;
		}
		Node next = sum2Rec(a, b);
		Node current = new Node((result + mod) % 10);
		mod = (result + mod) / 10;
		current.next = next;
		return current;
	}

	public static Node sum2(Node a, Node b) {
		if (a == null || b == null) {
			System.out.println("Nodes cannot be null!");
			System.exit(1);
		}
		Node s = sum2Rec(a, b);
		if (mod > 0) {
			Node n = new Node(1);
			n.next = s;
			return n;
		}
		else
			return s;
	}

	//any length 
	public static Node sum3(Node a, Node b) {
		if (a == null || b == null) {
			System.out.println("Nodes cannot be null!");
			System.exit(1);
		}
		int alen = a.length();
		int blen = b.length();
		if (alen > blen)
			b = padding(b, alen - blen);
		else if (alen < blen)
			a = padding(a, blen - alen);

		SumNode s = sum3Rec(a, b);
		if (s.carry > 0) {
			Node n = new Node(1);
			n.next = s.n;
			return n;
		}
		else
			return s.n;
		
	}

	public static class SumNode {
		Node n;
		int carry;
	}

	public static SumNode sum3Rec(Node a, Node b) {
		if (a == null && b == null)
			return new SumNode();

		SumNode next = sum3Rec(a.next, b.next);
		Node n = new Node((a.data + b.data + next.carry) % 10);
		n.next = next.n;
		int carry = (a.data + b.data + next.carry) / 10;
		SumNode curr = next;
		curr.n = n;
		curr.carry = carry;
		return curr;
	}

	public static Node padding(Node n, int x) {
		for (int i = 0; i < x; i ++)
			n = n.appendToHead(0);
		return n;
	}
}
