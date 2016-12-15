package problems;

public class FindMinimumInRotatedSortedArrayII {
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII a = new FindMinimumInRotatedSortedArrayII();
		System.out.println(a.findMin(new int[] { 10, 1, 10, 10, 10 }));
	}

	public int findMin(int[] nums) {
		int L = 0, R = nums.length - 1;
		while (L < R && nums[L] >= nums[R]) {
			int M = (L + R) / 2;
			if (nums[M] > nums[R]) {
				L = M + 1;
			} else if (nums[M] < nums[L]) {
				R = M;
			} else { // A[L] == A[M] == A[R]
				L = L + 1;
			}
		}
		return nums[L];
	}

	public int findMin1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0;
		int r = nums.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] == nums[r]) {
				r--;
			} else if (nums[mid] > nums[r]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return nums[l];

	}

}
