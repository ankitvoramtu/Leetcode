package problems;

public class SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII a = new SearchInRotatedSortedArrayII();
		System.out.println(a.search(new int[] { 1 }, 0));
	}

	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (A[mid] == target) {
				return true;
			} else if (A[l] < A[mid]) {
				if (target >= A[l] && target < A[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else if (A[mid] < A[l]) {
				if (target > A[mid] && target <= A[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			} else {
				l++;
			}
		}
		return false;
	}
}
