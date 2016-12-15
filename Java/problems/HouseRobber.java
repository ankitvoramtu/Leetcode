package problems;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int ret = 0;
		int prepre = 0;
		int pre = 0;
		for (int i = 0; i < nums.length; i++) {
			ret = Math.max(prepre + nums[i], pre);
			prepre = pre;
			pre = ret;
		}
		return ret;
	}
}
