package problems;

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater a = new TrappingRainWater();
		System.out.println(a.trap(new int[] { 2, 4, 6, 8, 10, 12 }));
	}

	public int trap(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int l = 0;
		int r = A.length - 1;
		int ret = 0;
		while (l < r) {
			int min = Math.min(A[l], A[r]);
			if (A[l] == min) {
				l++;
				while (A[l] < min) {
					ret += min - A[l];
					l++;
				}
			} else {
				r--;
				while (A[r] < min) {
					ret += min - A[r];
					r--;
				}
			}
		}
		return ret;
	}

	public int trap1(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] left = new int[A.length];
		int[] right = new int[A.length];

		left[0] = 0;
		right[A.length - 1] = 0;
		for (int i = 1; i < A.length; i++) {
			left[i] = Math.max(left[i - 1], A[i - 1]);
			right[A.length - 1 - i] = Math.max(right[A.length - i], A[A.length
					- i]);
		}
		int ret = 0;
		for (int i = 0; i < A.length; i++) {
			int height = Math.min(left[i], right[i]);
			if (height > A[i]) {
				ret += height - A[i];
			}
		}
		return ret;
	}

}
