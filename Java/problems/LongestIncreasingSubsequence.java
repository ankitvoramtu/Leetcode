package problems;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS1(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x) {
					i = m + 1;
				} else {
					j = m;
				}
			}
			tails[i] = x;
			if (i == size)
				++size;
		}
		return size;
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] ret = new int[nums.length];
		Arrays.fill(ret, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					ret[i] = Math.max(ret[i], ret[j] + 1);
				}
			}
		}
		int max = ret[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, ret[i]);
		}
		return max;
	}

}
