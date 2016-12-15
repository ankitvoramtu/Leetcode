package problems;

public class RangeSumQueryImmutable {
	private int[] ret;

	public RangeSumQueryImmutable(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		ret = nums;
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return ret[j];
		}
		return ret[j] - ret[i - 1];
	}

}
