package problems;

public class SearchForARange {

	public int[] searchRange(int[] A, int target) {
		int[] res = { -1, -1 };
		if (A == null || A.length == 0) {
			return res;
		}
		int ll = 0;
		int lr = A.length - 1;
		while (ll <= lr) {
			int m = (ll + lr) / 2;
			if (A[m] < target) {
				ll = m + 1;
			} else {
				lr = m - 1;
			}
		}
		int rl = 0;
		int rr = A.length - 1;
		while (rl <= rr) {
			int m = (rl + rr) / 2;
			if (A[m] <= target) {
				rl = m + 1;
			} else {
				rr = m - 1;
			}
		}
		if (ll <= rr) {
			res[0] = ll;
			res[1] = rr;
		}
		return res;
	}

	public int[] searchRange1(int[] A, int target) {
		int[] ret = new int[] { -1, -1 };
		if (A == null || A.length == 0) {
			return ret;
		}
		int l = 0;
		int r = A.length - 1;
		int m = (l + r) / 2;
		while (l <= r) {
			m = (l + r) / 2;
			if (A[m] == target) {
				ret[0] = m;
				ret[1] = m;
				break;
			} else if (A[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		if (A[m] != target) {
			return ret;
		}
		l = m;
		r = A.length - 1;
		while (l <= r) {
			m = (l + r) / 2;
			if (A[m] == target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		ret[1] = r;
		l = 0;
		r = ret[0];
		while (l <= r) {
			m = (l + r) / 2;
			if (A[m] == target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		ret[0] = l;

		return ret;
	}

}
