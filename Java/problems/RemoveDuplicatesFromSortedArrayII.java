package problems;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length <= 2) {
			return A.length;
		}
		int count = 2;
		for (int i = 2; i < A.length; i++) {
			if (A[i] == A[count - 1] && A[count - 1] == A[count - 2]) {
				continue;
			} else {
				A[count] = A[i];
				count++;
			}
		}
		return count;
	}
}
