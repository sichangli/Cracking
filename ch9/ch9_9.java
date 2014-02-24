import java.util.*;

public class ch9_9 {

	public static void main(String[] args) {
		nQueens(4);
	}

	public static void nQueens(int n) {
		int[] board = new int[n];
		helper(n, board, 0);
	}

	private static void helper(int n, int[] board, int row) {
		if (row == n) {
			printBoard(n, board);
			return;
		}

		for (int i = 0; i < n; i++) {
			board[row] = i;
			if (isValid(board, row)) {
				helper(n, board, row + 1);
			}
		}
	}

	private static void printBoard(int n, int[] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == board[i]) {
					System.out.print("x");
				} else {
					System.out.print("o");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isValid(int[] board, int row) {
		for (int i = 0; i < row; i++) {
			// check column
			if (board[i] == board[row]) {
				return false;
			}
			// check diagnal
			if (row - i == Math.abs(board[row] - board[i])) {
				return false;
			}
		}
		return true;
	}
}