package problems;

public class CombinationSumIV {
	public static void main(String[] args) {
		CombinationSumIV a = new CombinationSumIV();
		int ret = a.combinationSum4(new int[] { 1, 2, 3 }, 4);
		System.out.println(ret);
	}

	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target <= 0) {
			return 0;
		}
		int[] ret = new int[target + 1];
		ret[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					ret[i] += ret[i - nums[j]];
				}
			}
		}
		return ret[target];
	}
}
