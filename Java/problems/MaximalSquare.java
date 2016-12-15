package problems;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] edge = new int[m + 1][n + 1];
		int ret = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					edge[i][j] = Math.min(edge[i - 1][j],
							Math.min(edge[i][j - 1], edge[i - 1][j - 1])) + 1;
					ret = Math.max(edge[i][j], ret);
				}
			}
		}
		return ret * ret;
	}

}
