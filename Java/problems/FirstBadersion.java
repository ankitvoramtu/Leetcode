package problems;

public class FirstBadersion {
	public int firstBadVersion(int n) {
		int l = 1;
		int r = n;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (isBadVersion(m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	private boolean isBadVersion(int m) {
		// TODO Auto-generated method stub
		return false;
	}

}
