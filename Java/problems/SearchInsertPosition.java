package problems;

public class SearchInsertPosition {
	public static void main(String[] args) {
		SearchInsertPosition a = new SearchInsertPosition();
		System.out.println(a.searchInsert(new int[] { 1 }, 1));
	}

	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l <= r) {
			m = (l + r) / 2;
			if (A[m] == target) {
				return m;
			} else if (A[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return l;
	}
}
