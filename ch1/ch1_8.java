public class ch1_8 {

	public static void main(String[] args) {
		String s1 = "aaab";
		String s2 = "aab";
		System.out.println(isSubstring(s1, s2));
		String s3 = "erbottlewat";
		String s4 = "waterbottle";
		System.out.println(isRotation2(s3, s4));
	}

	//check whether s2 is substring of s1
	public static boolean isSubstring(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (i + j  >= s1.length())
					return false;
				else if (s1.charAt(i + j) != s2.charAt(j))
					break;
				else if (j == s2.length() - 1)
					return true;
			}
		}
		return false;
	}

	//check whether s2 is rotation of s1
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		for (int i = 1; i < s2.length(); i++) {
			String first = s2.substring(0, i);
			String second = s2.substring(i);
			if (isSubstring(s1, first) && isSubstring(s1, second))
				return true;
		}
		return false;
	}
	
	//better solution
	public static boolean isRotation2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
}
