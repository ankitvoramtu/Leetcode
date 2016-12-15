package problems;

public class RangeSumQuery2DImmutable {
	int[][] m;
	public RangeSumQuery2DImmutable(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		m = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				m[i + 1][j + 1] = m[i][j + 1] + m[i + 1][j] + matrix[i][j]
						- m[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return m[row2 + 1][col2 + 1] - m[row1][col2 + 1] - m[row2 + 1][col1] + m[row1][col1];
	}

}
