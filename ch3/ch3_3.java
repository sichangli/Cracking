import java.util.*;

public class ch3_3 {

}

class SetOfStacks {
	private ArrayList<Stack<Integer>> stacks;
	private int capacity;

	public SetOfStacks(int _capacity) {
		stacks = new ArrayList<Stack<Integer>>();
		capacity = _capacity;
	}

	public Integer push(Integer n) {
		Stack<Integer> s;
		if (stacks.isEmpty()) {
			s = new Stack<Integer>();
			stacks.add(s);
		} else {
			s = stacks.get(stacks.size() - 1);
		}
		// if excceed the capacity
		if (s.size() == capacity) {
			s = new Stack<Integer>();
			stacks.add(s);
		}

		s.push(n);
		return n;
	}

	public Integer pop() throws EmptyStackException {
		if (stacks.isEmpty()) {
			throw new EmptyStackException();
		}
		Stack<Integer> s = stacks.get(stacks.size() - 1);
		int n = s.pop();
		// remove the last stack if empty
		if (s.empty()) {
			stacks.remove(stacks.size() - 1);
		}
		return n;

	}

	public Integer peek() throws EmptyStackException {
		if (stacks.isEmpty()) {
			throw new EmptyStackException();
		}
		Stack<Integer> s = stacks.get(stacks.size() - 1);
		return s.peek();
	}

	//follow up
	public Integer popAt(int index) throws EmptyStackException {
		if (index >= stacks.size()) {
			throw new EmptyStackException();
		}
		Stack<Integer> s = stacks.get(index);
		int n = s.pop();
		if (s.empty()) {
			stacks.remove(index);
		}
		return n;


	}
}