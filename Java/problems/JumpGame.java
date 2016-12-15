package problems;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int ret = 0;
		if (nums == null || nums.length == 0) {
			return false;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (ret < i) {
				return false;
			}
			ret = Math.max(nums[i] + i, ret);
		}
		return ret >= nums.length - 1;
	}
	

	public boolean canJump2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int r = nums.length - 1;
		int i = 0;
		int max = nums[0];
		for (; i <= max; i++) {
			if (max >= r) {
				return true;
			}
			max = Math.max(max, nums[i] + i);
		}
		return false;
	}

}
