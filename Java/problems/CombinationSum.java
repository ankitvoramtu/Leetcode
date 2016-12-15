package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return ret;
		}
		Arrays.sort(candidates);
		helper(ret, new LinkedList<Integer>(), candidates, 0, target);
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> tmp,
			int[] candidates, int index, int target) {
		if (target == 0) {
			ret.add(new LinkedList<Integer>(tmp));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				tmp.add(candidates[i]);
				helper(ret, tmp, candidates, i, target - candidates[i]);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
