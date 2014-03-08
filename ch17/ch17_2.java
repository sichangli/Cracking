import java.util.*;

public class ch17_2 {

	public static void main(String[] args) {

	}

	public static boolean win(char[][] board, char p) {
		int n = board.length;
		int count = 0;
		// check rows
		for (int i = 0; i < n; i++) {
			count = 0;
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != p) {
					break;
				} else {
					count++;
				}
			}
			if (count == n) {
				return true;
			}
		}

		// check columns
		for (int j = 0; j < n; j++) {
			count = 0;
			for (int i = 0; i < n; i++) {
				if (board[i][j] != p) {
					break;
				} else {
					count++;
				}
			}
			if (count == n) {
				return true;
			}
		}

		// check diagonal
		count = 0;
		for (int i = 0; i < n; i++) {
			if (board[i][i] != p) {
				break;
			} else {
				count++;
			}
		}

		if (count == n) {
			return true;
		}

		// check reverse diagonal
		count = 0;
		for (int i = 0; i < n; i++) {
			if (board[i][n - 1 - i] != p) {
				break;
			} else {
				count++;
			}
		}

		if (count == n) {
			return true;
		}

		return false;

	}

}