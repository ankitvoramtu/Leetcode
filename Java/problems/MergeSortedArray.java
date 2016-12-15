package problems;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null) {
			return;
		}
		int idx1 = m - 1;
		int idx2 = n - 1;
		int idx3 = m + n - 1;
		while (idx1 >= 0 && idx2 >= 0) {
			if (A[idx1] > B[idx2]) {
				A[idx3--] = A[idx1];
				idx1--;
			} else {
				A[idx3--] = B[idx2];
				idx2--;
			}
		}
		while (idx2 >= 0) {
			A[idx3--] = B[idx2--];
		}
	}

}
