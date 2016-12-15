package problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix a = new SpiralMatrix();
		System.out.println(a.spiralOrder(new int[][] { { 2, 5, 8 },
				{ 4, 0, -1 } }));
		System.out.println(a.spiralOrder(new int[][] { { 1 } }));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> elements = new ArrayList<>();
		if (matrix.length == 0)
			return elements;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = -1;
		while (true) {
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][++col]);
			}
			if (--m == 0)
				break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[++row][col]);
			}
			if (--n == 0)
				break;
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][--col]);
			}
			if (--m == 0)
				break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[--row][col]);
			}
			if (--n == 0)
				break;
		}
		return elements;
	}

	public List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> ret = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ret;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		int min = Math.min(r, c);
		for (int level = 0; level < min / 2; level++) {
			for (int i = level; i < c - 1 - level; i++) {
				ret.add(matrix[level][i]);
			}
			for (int i = level; i < r - 1 - level; i++) {
				ret.add(matrix[i][c - 1 - level]);
			}
			for (int i = c - 1 - level; i > level; i--) {
				ret.add(matrix[r - 1 - level][i]);
			}
			for (int i = r - 1 - level; i > level; i--) {
				ret.add(matrix[i][level]);
			}
		}
		if (min % 2 == 1) {
			if (r < c) {
				for (int i = min / 2; i < c - min / 2; i++) {
					ret.add(matrix[r / 2][i]);
				}
			} else {
				for (int i = min / 2; i < r - min / 2; i++) {
					ret.add(matrix[i][c / 2]);
				}
			}
		}

		return ret;
	}
}
