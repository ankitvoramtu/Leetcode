package problems;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return A[L];
	}

	public int findMin1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;

		if (nums[start] < nums[end]) {
			return nums[0];
		}

		while (end - start > 1) {
			int mid = (end + start) / 2;
			if (nums[start] == nums[mid]) {
				start++;
			}
			if (nums[start] < nums[mid]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return nums[end];
	}
}
