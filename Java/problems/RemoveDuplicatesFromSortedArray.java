package problems;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[count]) {
				count++;
				A[count] = A[i];
			}
		}
		return count + 1;
	}
}
