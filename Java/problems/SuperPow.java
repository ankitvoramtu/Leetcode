package problems;

public class SuperPow {
	int base = 1337;

	public int superPow(int a, int[] b) {
		return helper(a, b, b.length - 1);
	}

	int helper(int a, int[] b, int endidx) {
		if (endidx == -1) {
			return 1;
		}
		int last_digit = b[endidx];
		return powmod(helper(a, b, endidx - 1), 10) * powmod(a, last_digit)
				% base;
	}

	int powmod(int a, int k) {
		a %= base;
		int result = 1;
		for (int i = 0; i < k; i++) {
			result = (result * a) % base;
		}
		return result;
	}
}
