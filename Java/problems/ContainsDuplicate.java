package problems;

import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
