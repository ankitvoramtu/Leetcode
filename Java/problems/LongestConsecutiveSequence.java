package problems;

import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		int ret = 1;
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		while (!set.isEmpty()) {
			Iterator<Integer> iter = set.iterator();
			int item = iter.next();
			set.remove(item);
			int len = 1;
			int i = item - 1;
			while (set.contains(i)) {
				set.remove(i--);
				len++;
			}
			i = item + 1;
			while (set.contains(i)) {
				set.remove(i++);
				len++;
			}
			if (len > ret) {
				ret = len;
			}
		}
		return ret;
	}
}
