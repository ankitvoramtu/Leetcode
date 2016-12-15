package problems;

public class SqrtX {

	public static void main(String[] args) {
		SqrtX a = new SqrtX();
		System.out.println(a.sqrt(16));
		System.out.println(a.sqrt(15));
		System.out.println(a.sqrt(17));
		System.out.println(a.sqrt(2));
	}

	// Newton's method
	public int sqrt(int x) {
		if (x < 0) {
			return -1;
		}
		if (x == 0) {
			return 0;
		}
		double yLast = 0;
		double y = 1;
		while (y != yLast) {
			yLast = y;
			y = (y + x / y) / 2;
		}
		return (int) y;
	}

	public int sqrt1(int x) {
		if (x < 0) {
			return -1;
		}
		if (x == 0) {
			return 0;
		}
		int l = 1;
		int r = x;
		int m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			if (x / m >= m && x / (m + 1) < m + 1) {
				return m;
			}
			if (x / m < m) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return m;
	}
}
