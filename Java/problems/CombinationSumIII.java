package problems;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (k > n || n < 1) {
			return ret;
		}
		helper(ret, new LinkedList<Integer>(), k, n, 1);
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> tmp, int len,
			int sum, int start) {
		if (len == 0 && sum == 0) {
			ret.add(new LinkedList<Integer>(tmp));
			return;
		}
		if (len == 0) {
			return;
		}
		for (int i = start; i <= 9; i++) {
			if (i <= sum) {
				tmp.add(i);
				helper(ret, tmp, len - 1, sum - i, i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

}
