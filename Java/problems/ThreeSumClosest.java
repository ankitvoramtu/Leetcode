package problems;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) {
			return 0;
		}
		Arrays.sort(num);
		int closet = num[0] + num[1] + num[2] - target;
		for (int i = 0; i < num.length - 2; i++) {
			int cur = twoSum(num, i + 1, target - num[i]);
			if (Math.abs(cur) < Math.abs(closet)) {
				closet = cur;
			}
		}
		return closet + target;
	}

	public int twoSum(int[] num, int left, int target) {
		int right = num.length - 1;
		int closet = num[left] + num[right] - target;
		while (left < right) {
			if (num[left] + num[right] == target) {
				return 0;
			}
			int cur = num[left] + num[right] - target;
			if (Math.abs(cur) < Math.abs(closet)) {
				closet = cur;
			}
			if (num[left] + num[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return closet;
	}
}
