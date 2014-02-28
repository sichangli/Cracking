import java.util.*;

public class ch11_6 {

	public static void main(String[] args) {

	}

	// idea: start from the first row and last column
	// if the last element in a row is smaller than n, we move to the next row
	// if the first element in a column is bigger than n, we move the column on left side 
	public static Point find(int[][] matrix, int n) {
		int row = 0;
		int column = matrix[0].length - 1;

		while (row <= matrix.length && column >= 0) {
			if (matrix[row][column] == n) {
				return new Point(row, column);
			} else if (matrix[row][column] < n) {
				row++;
			} else {
				column--;
			}
		}
		return null;
	}
}

class Point {
	private int x;
	private int y;

	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
}