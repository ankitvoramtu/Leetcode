package problems;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ret = new LinkedList<String>();
		if (nums == null || nums.length == 0) {
			return ret;
		}
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (num != nums[i]) {
				ret.add(num + "->" + nums[i]);
			} else {
				ret.add(Integer.toString(num));
			}
		}
		return ret;
	}
}
