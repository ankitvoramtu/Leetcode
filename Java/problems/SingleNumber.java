package problems;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			ret ^= nums[i];
		}
		return ret;
	}
}
