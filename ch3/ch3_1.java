import java.util.*;

public class ch3_1 {



}

class Stacks {
	private int capacity;  // size of each stack
	private int[] buffer;
	private int[] sizes = {0, 0, 0};

	public Stacks(int _capacity) {
		capacity = _capacity;
		buffer = new int[3 * capacity];
	}

	public void push(int sn, int e) throws Exception {
		if (sizes[sn] == capacity) {
			throw new Exception("out of space");
		}
		buffer[sn * capacity + sizes[sn]] = e;
		sizes[sn]++;
 	}

	public int pop(int sn) throws EmptyStackException {
		if (sizes[sn] == 0) {
			throw new EmptyStackException();
		}
		int result = buffer[sn * capacity + sizes[sn] - 1];
		sizes[sn]--;
		return result;
	}

	public int peek(int sn) {
		if (sizes[sn] == 0) {
			throw new EmptyStackException();
		}
		return buffer[sn * capacity + sizes[sn] - 1];
	}
}