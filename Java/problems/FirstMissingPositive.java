package problems;

public class FirstMissingPositive {
	public static void main(String[] args) {
		FirstMissingPositive a = new FirstMissingPositive();
		System.out.println(a.firstMissingPositive(new int[] { 1, 1 }));
	}

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		int tmp;
		for (int i = 0; i < A.length; i++) {
			if ((A[i] <= 0) || (A[i] > A.length) || (A[i] == A[A[i] - 1])) {
				continue;
			}
			tmp = A[A[i] - 1];
			A[A[i] - 1] = A[i];
			A[i] = tmp;
			i--;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
