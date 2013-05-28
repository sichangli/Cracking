import java.util.*;

public class ch1_3 {

	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "agbefdcdd";
		if (isPermutation(s1, s2))
			System.out.println(s1 + " and " + s2 + " are permutation");
		else
			System.out.println(s1 + " and " + s2 + " are not permutation");

		if (isPermutation2(s1, s2))
			System.out.println(s1 + " and " + s2 + " are permutation");
		else
			System.out.println(s1 + " and " + s2 + " are not permutation");
	}

	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if (hm.containsKey(s1.charAt(i))) {
				int val = hm.get(s1.charAt(i));
				val++;
				hm.put(s1.charAt(i), val);
			}
			else
				hm.put(s1.charAt(i), 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			if (hm.containsKey(s2.charAt(i))) {
				int val = hm.get(s2.charAt(i));
				val--;
				hm.put(s2.charAt(i), val);
			}
			else
				return false;	
		}

		Set<Character> ks = hm.keySet();
		for (char k : ks) {
			int val = hm.get(k);
			if (val != 0)
				return false;
		}
		return true;
	}

	public static boolean isPermutation2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] ascii = new int[256]; //assume ascii	
		for (int i = 0; i < s1.length(); i++)
			ascii[s1.charAt(i)]++;
		for (int i = 0; i < s2.length(); i++)
			ascii[s2.charAt(i)]--;
		for (int i = 0; i < 256; i++)
			if (ascii[i] != 0)
				return false;
		return true;
	}
}
