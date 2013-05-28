public class ch1_4 {

	public static void main(String[] args) {
		char[] s = "Mr John  Smith      ".toCharArray();
		System.out.println(s);
		replaceSpaces2(s, 14);
		System.out.println(s);
	}

	//replace in place
	public static void replaceSpaces(char[] s, int len) {
		int numOfSpaces = 0;
		for (int i = 0; i < len - 1; i++)		
			if (s[i] == ' ')
				numOfSpaces++;

		for (int i = len - 1; i >= 0; i--) {
			if (s[i] != ' ') {
				int newPos = i + numOfSpaces * 2;
				s[newPos] = s[i];
			}
			else {
				numOfSpaces--;
				int newPos = i + numOfSpaces * 2;
				s[newPos] = '%';
				s[newPos + 1] = '2';
				s[newPos + 2] = '0';
			}
		}
	}

	public static void replaceSpaces2(char[] s, int len) {
		int numOfSpaces = 0;
		for (int i = 0; i < len - 1; i++)		
			if (s[i] == ' ')
				numOfSpaces++;
		int newLen = len + 2 * numOfSpaces;
		for (int i = newLen - 1, j = len - 1; i >= 0; i--, j--) {
			if (s[j] != ' ')
				s[i] = s[j];
			else {
				s[i] = '0';
				s[--i] = '2';
				s[--i] = '%';
			}
		}
	}
}
