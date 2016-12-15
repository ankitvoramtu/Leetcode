package problems;

public class GuessNumberHigherOrLowerII {
	public int getMoneyAmount(int n) {
		int[][] table = new int[n + 1][n + 1];
		for (int j = 2; j <= n; j++) {
			for (int i = j - 1; i > 0; i--) {
				int globalMin = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					int localMax = k
							+ Math.max(table[i][k - 1], table[k + 1][j]);
					globalMin = Math.min(globalMin, localMax);
				}
				table[i][j] = i + 1 == j ? i : globalMin;
			}
		}
		return table[1][n];
	}

	public int getMoneyAmount2(int n) {
		int[][] table = new int[n + 1][n + 1];
		return helper(table, 1, n);
	}

	int helper(int[][] table, int s, int e) {
		if (s >= e) {
			return 0;
		}
		if (table[s][e] != 0) {
			return table[s][e];
		}
		int ret = Integer.MAX_VALUE;
		for (int x = s; x <= e; x++) {
			int tmp = x
					+ Math.max(helper(table, s, x - 1), helper(table, x + 1, e));
			ret = Math.min(ret, tmp);
		}
		table[s][e] = ret;
		return ret;
	}

}
