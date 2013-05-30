public class ch1_7{

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0, 0, 3}, {3, 3, 3}, {3, 3, 0}};
		print2Array(matrix);
		set0(matrix);
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
}

