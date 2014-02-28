import java.util.*;

public class ch11_7 {

	public static void main(String[] args) {

	}

	// the idea is to first sort the array by height. Then use dp: treat each one as the bottom
	// similar to ch9_10
	public static ArrayList<Person> longest(Person[] p) {
		Arrays.sort(p);
		ArrayList<Person>[] results = new ArrayList[p.length]; 
		for (int i = 0; i < p.length; i++) {
			helper(p, i, results);
		}

		// find the result with maximum length
		ArrayList<Person> result = null;
		for (ArrayList<Person> r : results) {
			result = getLongerSequence(result, r);
		}

		return result;
	}

	private static void helper(Person[] p, int index, ArrayList<Person>[] results) {
		 ArrayList<Person> result = null;
		for (int i = 0; i < index; i++) {
			// if it can be below the i th person
			if (p[index].canBeBelow(p[i])) {
				result = getLongerSequence(result, results[i]);
			}
		}

		ArrayList<Person> newResult = new ArrayList<Person>();
		if (result != null) {
			newResult.addAll(result);
		}
		newResult.add(p[index]);
		results[index] = newResult;
	}

	private static ArrayList<Person> getLongerSequence(ArrayList<Person> a, ArrayList<Person> b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} else {
			return a.size() > b.size() ? a : b;
		}
	}

}

class Person implements Comparable {
	private int height;
	private int weight;

	public int compareTo(Object o) {
		Person op = (Person) o;
		if (height == op.height) {
			return weight - op.weight;
		} else {
			return height - op.height;
		}
	}

	public boolean canBeBelow(Person other) {
		return height > other.height && weight > other.height;
	}


}