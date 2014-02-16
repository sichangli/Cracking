public class ch1_7{

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0, 0, 3}, {3, 3, 3}, {3, 3, 0}};
		print2Array(matrix);
		set00(matrix);
		print2Array(matrix);
	}

	public static void print2Array(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void set0(int[][] matrix) {
		if (matrix == null)
			return;
		int[] rows = new int[matrix.length];
		int[] columns = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rows[i] == 1 || columns[j] == 1)
					matrix[i][j] = 0;
			}
		}
	}

	// using constant space
	public static void set00(int[][] matrix) {
		if (matrix == null)
			return;

		boolean fr0 = false;
		boolean fc0 = false;

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				fr0 = true;
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				fc0  = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// set first row to 0 if it has 0
		if (fr0 == true) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}

		}

		if (fc0 = true) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

	}
}

