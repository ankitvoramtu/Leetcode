package problems;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int[] output = new int[nums.length];
		output[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			nums[i] = nums[i + 1] * nums[i];
		}
		output[nums.length - 1] = output[nums.length - 2];
		for (int i = nums.length - 2; i >= 1; i--) {
			output[i] = output[i - 1] * nums[i + 1];
		}
		output[0] = nums[1];
		return output;
	}

}
