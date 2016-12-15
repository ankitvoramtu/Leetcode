package problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (map.containsKey(target - val)) {
				return new int[] { map.get(target - val), i };
			}
			map.put(val, i);
		}
		return null;
	}
}
