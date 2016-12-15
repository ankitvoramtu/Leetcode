package problems;

public class DivideTwoIntegers {
	public static void main(String[] args) {
		DivideTwoIntegers a = new DivideTwoIntegers();
		System.out.println(a.divide(2147483647, 2));
		System.out.println(a.divide(0, 1));
	}

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
			return 1;
		}
		if (divisor == Integer.MIN_VALUE) {
			return 0;
		}
		boolean sign = ((dividend ^ divisor) >>> 31 != 1) ? true : false;
		int ret = 0;
		if (dividend == Integer.MIN_VALUE) {
			dividend = dividend + Math.abs(divisor);
			ret++;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int factor = divisor;
		int count = 0;
		while (dividend >> 1 >= factor) {
			factor = factor << 1;
			count++;
		}
		while (dividend >= divisor) {
			if (dividend >= factor) {
				ret += 1 << count;
				dividend -= factor;
			}
			factor = factor >> 1;
			count--;
		}
		return sign ? ret : -ret;
	}
}
