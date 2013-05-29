public class ch1_5{

	public static void main(String[] args) {
		String  s = "aabcccccaaa";
		String ns = compress2(s);
		System.out.println(s);
		System.out.println(ns);
	}

	public static String compress(String s) {
		if (s.isEmpty())
			return s;
		StringBuffer sb = new StringBuffer();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 == s.length()) {
				sb.append(s.charAt(i));
				sb.append(count);
			}
			else if (s.charAt(i) == s.charAt(i + 1))
				count++;
			else {
				sb.append(s.charAt(i));
				sb.append(count);
				count = 1;
			}
		}
		String ns = sb.toString();
		if (ns.length() < s.length())
			return ns;
		else
			return s;
	}

	//using recursion
	public static String compress2(String s) {
		String ns = helper(s, 1);
		if (ns.length() < s.length())
			return ns;
		else
			return s;
	}
	
	public static String helper(String s, int n) {
		if (s.isEmpty())
			return s;
		else if (s.length() == 1)
			return s + n;
		else if (s.charAt(0) == s.charAt(1))
			return helper(s.substring(1), n + 1);
		else
			return Character.toString(s.charAt(0)) + n + helper(s.substring(1), 1);		
	}
}
