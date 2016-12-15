package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	// Iterative
	public List<List<Integer>> subsetsWithDup1(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return ret;
		}
		ret.add(new ArrayList<Integer>());
		Arrays.sort(num);
		int start = 0;
		for (int i = 0; i < num.length; i++) {
			int size = ret.size();
			for (int j = start; j < size; j++) {
				List<Integer> item = new ArrayList<Integer>(ret.get(j));
				item.add(num[i]);
				ret.add(item);
			}
			// can't use if (i > 0 && num[i] == num[i-1]) {
			if (i < num.length - 1 && num[i] == num[i + 1]) {
				start = size;
			} else {
				start = 0;
			}
		}
		return ret;
	}
}
