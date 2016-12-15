package problems;

public class PowXN {
	public double myPow(double x, int n) {
		double result = 1.0;
		for (int i = n; i != 0; i /= 2, x *= x) {
			if (i % 2 != 0) {
				result *= x;
			}
		}
		return n < 0 ? 1.0 / result : result;
	}

	public double pow3(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double ret = 1.0;
		if (n < 0) {
			x = 1 / x;
		}
		n = Math.abs(n);
		boolean isNeg = false;
		if (n % 2 == 1 && x < 0) {
			isNeg = true;
		}
		x = Math.abs(x);
		while (n > 0) {
			if (n % 2 == 1) {
				ret *= x;
			}
			x *= x;
			n = n >> 1;
		}
		return isNeg ? -ret : ret;
	}

	public double pow4(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double ret = 1.0;
		if (n < 0) {
			if (x >= 1.0 / Double.MAX_VALUE || x <= 1.0 / -Double.MAX_VALUE) {
				x = 1 / x;
			} else {
				return Double.MAX_VALUE;
			}
			if (n == Integer.MIN_VALUE) {
				ret *= x;
				n++;
			}
		}
		n = Math.abs(n);
		boolean isNeg = false;
		if (n % 2 == 1 && x < 0) {
			isNeg = true;
		}
		x = Math.abs(x);
		while (n > 0) {
			if (n % 2 == 1) {
				if (ret > Double.MAX_VALUE / x) {
					return Double.MAX_VALUE;
				}
				ret *= x;
			}
			x *= x;
			n = n >> 1;
		}

		return isNeg ? -ret : ret;
	}

	/**
	 * Assume no overflow
	 */
	public double pow2(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double half = pow2(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		}
		if (n > 0) {
			return half * half * x;
		} else {
			return half * half / x;
		}

	}

}
