import java.util.*;

public class ch17_1 {

	public static void main(String[] args) {
		swap(4, 5);
		swap2(1, 10);

	}

	//swap in place
	public static void swap(int a, int b) {
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		a = a - b;
		b = a + b;
		a = b - a;

		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}

	// bit manipulation
	public static void swap2(int a, int b) {
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}

}