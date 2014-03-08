import java.util.*;

public class ch17_9 {

	public static void main(String[] args) {
	}

	public static HashMap<String, Integer> map = new HashMap<String, Integer>();


	public static void setup(String[] book) {
		for (String w : book) {
			String lw = w.toLowerCase();
			if (!map.containsKey(lw)) {
				map.put(lw, 1);
			} else {
				map.put(lw, map.get(lw) + 1);
			}
		}
	}

	public static int getFrequency(String word) {
		if (null == word || word.isEmpty()) {
			return -1;
		}

		word = word.toLowerCase();
		if (map.containsKey(word)) {
			return map.get(word);
		} else {
			return 0;
		}
	}
}