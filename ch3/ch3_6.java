import java.util.*;

public class ch3_6 {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		Stack<Integer> s2 = sortStack(s);
		while (!s2.empty())
			System.out.println(s2.pop());
	}

	public static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s.empty()) {
			int top = s.pop();
			while (!s2.empty() && top < s2.peek()) {
				s.push(s2.pop());
			}
			s2.push(top);
		}
		return s2;
	}

}
