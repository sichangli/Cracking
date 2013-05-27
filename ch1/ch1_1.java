public class ch1_1 {
	
	public static void main(String[] args) {
		String s = "aabbcdefg";
		if (isUniqueStr3(s))
			System.out.println(s + " is unique!");
		else
			System.out.println(s + " is not unique!");

	}

	public static boolean isUniqueStr(String s) {
		if (s.length() > 256)	//assume ascii
			return false;
		boolean[] ascii = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(i);
			if (ascii[value])
				return false;
			ascii[value] = true; 
		}
		return true;
	}	
	
	public static boolean isUniqueStr2(String s) {
		if (s.length() > 26)	//assume lower case letters
			return false;
		int bitmap = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if (((1 << val) & bitmap) != 0)
				return false;
			bitmap |= (1 << val);
		}
		return true;
	}
	
	public static boolean isUniqueStr3(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					return false;
			}
		}
		return true;
	}
}
