import java.util.*;

public class ch9_2 {

	public static void main(String[] args) {
		System.out.println(paths(2, 2));
		System.out.println(paths2(2, 2));				
	}


	//dp
	public static int paths(int x, int y) {
		int[][] grid = new int[x + 1][y + 1];

		// set first row
		for (int i = 0; i <= y; i++) {
			grid[0][i] = 1; 
		}

		// set first column
		for (int i = 0; i <= x; i++) {
			grid[i][0] = 1;
		}

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
			}
		}
		return grid[x][y];
	}

	// math: x + y choose x = (x+y)! / x!y!
	public static int paths2(int x, int y) {
		return fatorial(x + y) / (fatorial(x) * fatorial(y));
	}

	private static int fatorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	} 

	//follow up   dp
	public static int limitPaths(int x, int y) {
		int[][] grid = new int[x + 1][y + 1];

		// set first row
		for (int i = 0; i <= y; i++) {
			if (true == isFree(0, i)) {
				grid[0][i] = 1; 
			} else {
				grid[0][i] = 0;
			}
		}

		// set first column
		for (int i = 0; i <= x; i++) {
			grid[i][0] = 1;
		}

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (true == isFree(i, j))
					grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
				else 
					grid[i][j] = 0;
			}
		}
		return grid[x][y];
	}

	public static class Point {
		int x;
		int y;
		public Point(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}

	// follow up find a path
	public static boolean findLimitPath(int x, int y, ArrayList<Point> path, HashSet<Point> blocked) {
		if (!isFree(x, y))
			return false;

		Point p = new Point(x, y);

		if (x == 0 && y == 0) {
			path.add(p);
			return true;
		}

		// if is has been checked that it's blocked
		if (blocked.contains(p)) {
			return false;
		}

		if (y >= 1 && findLimitPath(x, y - 1, path, blocked) == true) {
			path.add(p);
			return true;
		}

		if (x >= 1 && true == findLimitPath(x - 1, y, path, blocked)) {
			path.add(p);
			return true;
		}

		blocked.add(p);
		return false;
	}

	private static boolean isFree(int x, int y) {
		return true;
	}


}