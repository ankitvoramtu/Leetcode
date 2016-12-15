package problems;

public class PerfectSquares {
	public static void main(String[] args) {
		PerfectSquares a = new PerfectSquares();
		int ret = a.numSquares(24);
		System.out.println(ret);
	}

	public int numSquares(int n) {
		int[] ret = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, ret[i - j * j] + 1);
			}
			ret[i] = min;
		}
		return ret[n];
	}

}
