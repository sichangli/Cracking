public class ch2_3 {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		n.print();
		deleteMiddle(n.next.next);
		n.print();

	}

	public static void deleteMiddle(Node middle) {
		if (middle == null || middle.next == null) {
			System.out.println("You are not deleting the middle node!");
			System.exit(1);
		}
		//replace middle's data with middle + 1 's data
		middle.data = middle.next.data;
		//delete middle + 1
		middle.next = middle.next.next;
	}
}
