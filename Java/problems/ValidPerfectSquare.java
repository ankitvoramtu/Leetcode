package problems;

public class ValidPerfectSquare {
	public boolean isPerfectSquare1(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}

	public boolean isPerfectSquare(int num) {
		int l = 1;
		int r = num;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (m * m == num) {
				return true;
			} else if (num / m < m) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return false;
	}

}
