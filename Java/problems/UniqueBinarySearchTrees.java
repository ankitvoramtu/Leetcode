package problems;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] ret = new int[n + 1];
		ret[0] = 1;
		ret[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				ret[i] += ret[j] * ret[i - 1 - j];
			}
		}
		return ret[n];
	}
}
