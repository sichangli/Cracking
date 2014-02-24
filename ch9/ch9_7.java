import java.util.*;

public class ch9_7 {

	public static void main(String[] args) {
	}

	private enum Color {
		BLACK, WHITE, RED, GREEN, BLUE
	}

	public static void paintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length)
			return;

		if (screen[y][x] == oldColor) {
			screen[y][x] = newColor;
			paintFill(screen, x - 1, y, oldColor, newColor);
			paintFill(screen, x + 1, y, oldColor, newColor);
			paintFill(screen, x, y - 1, oldColor, newColor);
			paintFill(screen, x, y + 1, oldColor, newColor);
		}
	}

}