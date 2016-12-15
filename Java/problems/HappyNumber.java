package problems;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}
		int p1 = n;
		int p2 = n;
		while (true) {
			p1 = calc(p1);
			p2 = calc(calc(p2));
			if (p2 == 1) {
				return true;
			}
			if (p2 == p1) {
				return false;
			}
		}
	}

	private int calc(int n) {
		int ret = 0;
		while (n > 0) {
			ret += (n % 10) * (n % 10);
			n = n / 10;
		}
		return ret;
	}

	public boolean isHappy2(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			if (set.contains(n)) {
				return false;
			}
			set.add(n);
			n = digitSquareSum(n);
		}
		return true;
	}

	int digitSquareSum(int n) {
		int sum = 0, tmp;
		while (n != 0) {
			tmp = n % 10;
			sum += tmp * tmp;
			n /= 10;
		}
		return sum;
	}
}
