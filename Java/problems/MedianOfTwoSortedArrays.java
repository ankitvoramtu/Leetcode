package problems;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] a = new int[] { 0 };
		int[] b = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(new MedianOfTwoSortedArrays()
				.findMedianSortedArrays(a, b));

	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		int totalLen = lenA + lenB;
		if (totalLen % 2 == 0) {
			return (findKth(A, 0, lenA - 1, B, 0, lenB - 1, totalLen / 2) + findKth(
					A, 0, lenA - 1, B, 0, lenB - 1, totalLen / 2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, lenA - 1, B, 0, lenB - 1, totalLen / 2 + 1);
		}
	}

	public double findKth(int A[], int a1, int a2, int B[], int b1, int b2,
			int k) {
		int a = a2 - a1 + 1;
		int b = b2 - b1 + 1;
		if (a > b) {
			return findKth(B, b1, b2, A, a1, a2, k);
		}
		if (a == 0) {
			return B[b1 + k - 1];
		}
		if (k == 1) {
			return Math.min(A[a1], B[b1]);
		}
		int posA = Math.min(k / 2, a);
		int posB = k - posA;
		if (A[a1 + posA - 1] == B[b1 + posB - 1]) {
			return A[a1 + posA - 1];
		} else if (A[a1 + posA - 1] < B[b1 + posB - 1]) {
			return findKth(A, a1 + posA, a2, B, b1, b1 + posB - 1, posB);
		} else {
			return findKth(A, a1, a1 + posA - 1, B, b1 + posB, b2, posA);
		}
	}
}
