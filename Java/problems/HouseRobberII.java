package problems;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(helper(nums, 0, nums.length - 2),
				helper(nums, 1, nums.length - 1));

	}

	public int helper(int[] nums, int l, int r) {
		int v1 = 0;
		int v2 = 0;
		int ret = 0;
		for (int i = l; i <= r; i++) {
			ret = Math.max(v1 + nums[i], v2);
			v1 = v2;
			v2 = ret;
		}
		return ret;
	}

}
