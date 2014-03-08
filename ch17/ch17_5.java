import java.util.*;

public class ch17_5 {

	public static void main(String[] args) {

	}

	enum Color {
		R, Y, G, B
	}

	public static void guess(Color[] guess, Color[] solution) {
		HashMap<Color, Integer> map = new HashMap<Color, Integer>();
		int hits = 0;
		int pHits = 0;

		for (int i = 0; i < solution.length; i++) {
			if (guess[i] != solution[i]) {
				if (!map.containsKey(solution[i])) {
					map.put(solution[i], 1);
				} else {
					map.put(solution[i], map.get(solution[i]) + 1);
				}
			} else {
				hits++;
			}
		}

		// count the pHits;
		for (int i = 0; i < solution.length; i++) {
			if (guess[i] != solution[i] && map.containsKey(guess[i]) && map.get(guess[i]) > 0) {
				pHits++;
				map.put(guess[i], map.get(guess[i]) - 1);
			}
		}

		System.out.println("Hits: " + hits + "  pHits: " + pHits);
	}
}