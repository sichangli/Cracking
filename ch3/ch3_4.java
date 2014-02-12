import java.util.*;

public class ch3_4 {
	public static void main(String[] args) {
		int n = 5;
		Stack<Integer> t1 = new Stack<Integer>();
		for (int i = n; i >= 1; i--) {
			t1.push(i);
		}
		Stack<Integer> t2 = new Stack<Integer>();
		Stack<Integer> t3 = new Stack<Integer>();
		move(t1, t3, t2, 5);

		// print t3
		while (!t3.empty()) {
			System.out.println(t3.pop());
		}
	}

	public static void move(Stack<Integer> source, Stack<Integer> target, Stack<Integer> temp, int n) {
		if (n == 0) {
			return;
		}
		// move n - 1 to temp
		move(source, temp, target, n - 1);
		// move last one to target
		int top = source.pop();
		target.push(top);
		// move n - 1 to target
		move(temp, target, source, n - 1);
	}

}