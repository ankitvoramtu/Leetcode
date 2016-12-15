package problems;

public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int r = 0;
		int c = n - 1;
		while (c >= 0 && r < m) {
			if (target == matrix[r][c]) {
				return true;
			} else if (target > matrix[r][c]) {
				r++;
			} else {
				c--;
			}
		}
		return false;
	}

}
