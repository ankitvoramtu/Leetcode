package problems;

import java.util.Arrays;

public class SpiralMatrixII {
	public static void main(String[] args) {
		SpiralMatrixII a = new SpiralMatrixII();
		int[][] arr = a.generateMatrix(3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}
		int[][] ret = new int[n][n];
		int level = n / 2;
		int num = 1;
		for (int i = 0; i < level; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				ret[i][j] = num++;
			}
			for (int j = i; j < n - 1 - i; j++) {
				ret[j][n - 1 - i] = num++;
			}
			for (int j = n - 1 - i; j >= i + 1; j--) {
				ret[n - 1 - i][j] = num++;
			}
			for (int j = n - 1 - i; j >= i + 1; j--) {
				ret[j][i] = num++;
			}
		}
		if (n % 2 != 0) {
			ret[level][level] = num;
		}
		return ret;
	}
}
