package problems;

import java.util.Arrays;

public class MaximalRectangle {
	/*
	 * The DP solution proceeds row by row, starting from the first row. Let the
	 * maximal rectangle area at row i and column j be computed by [right(i,j) -
	 * left(i,j)]*height(i,j).
	 * 
	 * All the 3 variables left, right, and height can be determined by the
	 * information from previous row, and also information from the current row.
	 * So it can be regarded as a DP solution. The transition equations are:
	 * 
	 * 
	 * left(i,j) = max(left(i-1,j), curleft), curleft can be determined from the
	 * current row
	 * 
	 * right(i,j) = min(right(i-1,j), curright), curright can be determined from
	 * the current row
	 * 
	 * height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
	 * 
	 * height(i,j) = 0, if matrix[i][j]=='0'
	 */
	public static void main(String[] args) {
		MaximalRectangle a = new MaximalRectangle();
		System.out.println(a.maximalRectangle(new char[][] { { '1' } }));
		System.out.println(a.maximalRectangle(new char[][] {
				{ '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];

		Arrays.fill(right, n);

		int max = 0;

		for (int i = 0; i < m; i++) {
			int curLeft = 0;
			int curRight = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], curLeft);
				} else {
					left[j] = 0;
					curLeft = j + 1;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], curRight);
				} else {
					right[j] = n;
					curRight = j;
				}
			}

			for (int j = 0; j < n; j++) {
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}
		return max;
	}
}
