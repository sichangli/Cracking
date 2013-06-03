public class ch2_2 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(5);
		n.appendToTail(6);
		n.print();
		System.out.println(findLastKth3(n, 1).data);
	}

	public static Node findLastKth(Node n, int k) {
		if (n == null) {
			System.out.println("Node cannot be null!");
			System.exit(1);
		}
		int size = 0;
		for (Node i = n; i != null; i = i.next)
			size++;

		if (k > size || k <= 0) {
			System.out.println("Invalid k!");
			System.exit(1);
		}

		int order = size - k;		
		for (int i = 1; i <= order; i++)
			n = n.next;

		return n;
	}

	//2 pointers
	public static Node findLastKth2(Node n, int k) {
		if (n == null) {
			System.out.println("Node cannot be null!");
			System.exit(1);
		}
		if (k <= 0) {
			System.out.println("Invalid k!");
			System.exit(1);
		}
		Node first = n;
		Node second = n;
		for (int i = 1; i <= k; i++)
			first = first.next;
		while (first != null) {
			second = second.next;
			first = first.next;
		}
		return second;
	}

	static int index = 0;  //cannot use Integer because it's immutable.
	//recursion
	public static Node findLastKth3(Node n, int k) {
		if (n == null) {
			return null;
		}
		Node result =  findLastKth3(n.next, k);
		index++;
		if (index == k)
			return n;
		else
			return result;
	}
}
