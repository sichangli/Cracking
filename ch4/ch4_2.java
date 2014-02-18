import java.util.*;

public class ch4_2 {

	public static void main(String[] args) {
		
	}

	public static boolean search(Graph g, Node start, Node end) {
		for (Node n : g.nodes) {
			n.visited = false;
		}

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);

		while (!q.isEmpty()) {
			Node h = q.poll();
			if (h == end) {
				return true;
			}

			if (!h.visited) {
				for (Node nei : h.neighbors) {
					q.add(nei);
				}
			}
			h.visited = true;
		}

		return false;
	}

}

class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();
}

class Node {
	ArrayList<Node> neighbors = new ArrayList<Node>();
	boolean visited;
}