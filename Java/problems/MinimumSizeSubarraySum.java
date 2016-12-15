package problems;

public class MinimumSizeSubarraySum {
	/*
	 * We can use 2 points to mark the left and right boundaries of the sliding
	 * window. When the sum is greater than the target, shift the left pointer;
	 * when the sum is less than the target, shift the right pointer.
	 */

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0;
		int r = 0;
		int sum = 0;
		int ret = Integer.MAX_VALUE;
		while (r < nums.length) {
			sum += nums[r++];
			while (sum >= s) {
				ret = Math.min(ret, r - l);
				sum -= nums[l++];
			}
		}
		return ret == Integer.MAX_VALUE ? 0 : ret;
	}
}
