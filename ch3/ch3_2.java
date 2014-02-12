import java.util.*;

public class ch3_2 {

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(1);
		System.out.println(s.min());
		s.push(0);
		s.push(2);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
	}
}

class MyStack extends Stack<Integer> {
	Stack<Integer> minStack;

	public MyStack() {
		minStack = new Stack<Integer>();
	}

	public Integer pop() {
		int top = super.pop();
		if (top == minStack.peek()) {
			minStack.pop();
		}
		return top;
	}

	public Integer push(Integer n) {
		if (n <= min()) {
			minStack.push(n);
		}
		return super.push(n);
	}

	public int min() {
		if (minStack.empty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}
}