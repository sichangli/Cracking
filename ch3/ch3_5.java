import java.util.*;

public class ch3_5 {

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.add(4);
		System.out.println(q.remove());
	}

}

class MyQueue<E> {
	Stack<E> s1;
	Stack<E> s2;
	int size;

	public MyQueue() {
		s1 = new Stack<E>();
		s2 = new Stack<E>();
	}

	//always push to s1
	public boolean add(E e) {
		s1.push(e);
		size++;
		return true;
	}

	private void reverse() {
		while (!s1.empty()) {
			s2.push(s1.pop());
		}

	}

	public E peek() {
		if (size == 0)
			return null;
		if (s2.empty()) {
			reverse();
		}
		return s2.peek();
	}

	public E remove() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		if (s2.empty()) {
			reverse();
		}
		size--;
		return s2.pop();
	}

}