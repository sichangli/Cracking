public class ch1_6 {

	public static void main(String[] args) {
		int[][] m = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		print2Array(m);
		rotate(m);
		System.out.println();
		print2Array(m);
	}

	public static void print2Array(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] m) {
		rotateRec(m, 0);	
	}

	public static void rotateRec(int[][] m, int layer) {
		if (layer == m.length / 2)
			return;
		int from = layer;
		int to = m.length - 1 - from;
		for (int i = from; i < to; i++) {
			int offset = i - from;
			int temp = m[from][i];          	//top -> temp
			m[from][i] = m[to - offset][from];   	//left -> top
			m[to - offset][from] = m[to][to - offset];	//bottom -> left
			m[to][to - offset] = m[from + offset][to];	//right -> bottom
			m[from + offset][to] = temp;         	//temp -> right
		}

		rotateRec(m, layer + 1);
	}

	//another solution
	public static void rotate2(int[][] matrix) {   //1.6
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			rotateAtLayer(matrix, layer);
			//print2Array(matrix);
		}
	}
		
	public static void rotateAtLayer(int[][] matrix, int layer) { //helper function for 1.6
		int first = layer;
		int last  = matrix.length - layer - 1;
		//System.out.println("Yes");
		for (int i = first; i < last; i ++) {
			System.out.println("Yes");
			int offset = i - first;
			int top = matrix[first][i];
			matrix[first][i] = matrix[last - offset][first];  //left to top
			//System.out.println(matrix[0][2]);
			matrix[last - offset][first] = matrix[last][last - offset]; //bottom to left
			matrix[last][last - offset] = matrix[i][last];//right to bottom
			matrix[i][last] = top;//top to right
			//print2Array(matrix);
		}
	}
}
