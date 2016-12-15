package problems;

public class MissingNumber {
	public static void main(String[] args) {
		MissingNumber a = new MissingNumber();
		int ret = a.missingNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(ret);
	}

	public int missingNumber(int[] nums) {
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		return xor ^ i;
	}

	public int missingNumber1(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int ret = 0;
		for (int j = 0; j < 32; j++) {
			int mask = 1 << j;
			int zero = 0;
			int one = 0;
			for (int i = 0; i < nums.length; i++) {
				if (j > 0 && (nums[i] & (0xffffffffL >>> (32 - j))) != ret) {
					continue;
				}
				if ((nums[i] & mask) == 0) {
					zero++;
				} else {
					one++;
				}
			}
			if (zero > one) {
				ret |= mask;
			}

		}
		return ret;
	}
}
