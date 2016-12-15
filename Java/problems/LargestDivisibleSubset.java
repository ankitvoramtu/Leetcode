package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int[] parent = new int[nums.length];
		int[] count = new int[nums.length];
		int max = 0, maxind = -1;
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i; j < nums.length; j++) {
				if (nums[j] % nums[i] == 0 && count[i] < 1 + count[j]) {
					count[i] = 1 + count[j];
					parent[i] = j;
					if (count[i] > max) {
						max = count[i];
						maxind = i;
					}
				}
			}
		}
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < max; i++) {
			ret.add(nums[maxind]);
			maxind = parent[maxind];
		}
		return ret;
	}

}
