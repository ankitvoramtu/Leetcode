package problems;

public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths a = new UniquePaths();
		System.out.println(a.uniquePaths(7, 3));
		System.out.println(a.uniquePaths(1, 2));
		System.out.println(a.uniquePaths(10, 10));
	}

	// Dynamic programming
	public int uniquePaths(int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		}
		int ret[] = new int[n];
		ret[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ret[j] = ret[j - 1] + ret[j];
			}
		}
		return ret[n - 1];
	}

	// Recursive: (May out of memory)
	public int uniquePaths1(int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	// Math method
	public int uniquePaths2(int m, int n) {
		return combination(m + n - 2, Math.max(m - 1, n - 1));
	}

	public int combination(int n, int k) {
		return (int) (factor(k + 1, n) / factor(1, n - k));
	}

	public long factor(int start, int end) {
		long ret = 1;
		for (int i = start; i <= end; i++) {
			ret *= i;
		}
		return ret;
	}

}
