package problems;

public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int l = 0, r = A.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (target == A[mid]) {
				return mid;
			}
			// must use <=, not < here
			if (A[l] <= A[mid]) {
				if (target < A[mid] && target >= A[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (target <= A[r] && target > A[mid]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}

}
