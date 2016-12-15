package problems;

public class IntegerBreak {
	public int integerBreak2(int n) {
		if (n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}
		int product = 1;
		while (n > 4) {
			product *= 3;
			n -= 3;
		}
		product *= n;
		return product;
	}

	public int integerBreak(int n) {
		if (n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}
		if (n == 4) {
			return 4;
		}
		int c1 = 3;
		int c2 = 4;
		int c3 = 6;
		for (int i = 6; i <= n; i++) {
			int tmp = Math.max(c1 * 3, c2 * 2);
			c1 = c2;
			c2 = c3;
			c3 = tmp;
		}
		return c3;

	}

}
