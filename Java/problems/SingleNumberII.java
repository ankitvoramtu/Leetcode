package problems;

public class SingleNumberII {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int one = 0, two = 0, three = 0;
		for (int i = 0; i < nums.length; i++) {
			two |= one & nums[i];
			one ^= nums[i];
			three = two & one;
			one &= ~three;
			two &= ~three;
		}
		return one;
	}

	public int singleNumber1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int ret = 0;
		int[] digits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				digits[i] += (nums[j] >> i) & 1;
			}
			ret += (digits[i] % 3) << i;
		}
		return ret;
	}

}
