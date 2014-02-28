import java.util.*;

public class ch11_2 {

	public static void main(String[] args) {

	}

	public static void sortStrings(String[] strings) {
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for (String s : strings) {
			String key = sortString(s);
			if (!map.containsKey(key)) {
				map.put(key, new LinkedList<String>());
			}
			LinkedList<String> list = map.get(key);
			list.add(s);
		}

		int i = 0;
		for (String key : map.keySet()) {
			for (String s : map.get(key)) {
				strings[i++] = s;
			}
		}
	}

	private static String sortString(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		return sorted;
	}

}