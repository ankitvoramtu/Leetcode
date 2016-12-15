package problems;

import java.util.Random;

public class RandomPickIndex {
	int[] arr;
	Random random;

	public RandomPickIndex(int[] nums) {
		arr = nums;
		random = new Random();
	}

	public int pick(int target) {
		int index = 0;
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				int val = random.nextInt(count);
				if (val + 1 == count) {
					index = i;
				}
				count++;
			}
		}
		return index;
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */
