package problems;

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}
		// find the right most 1
		xor = xor & (~(xor - 1));
		// separate into two different groups
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & xor) == 0) {
				ret[0] ^= nums[i];
			} else {
				ret[1] ^= nums[i];
			}
		}
		return ret;
	}
}
