package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
	public static void main(String[] args) {
		PermutationsII a = new PermutationsII();
		System.out.println(a.permuteUnique(new int[] { 1, 2, 1 }));
	}

	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return ret;
		}
		Arrays.sort(num);
		helper(ret, new ArrayList<Integer>(), new boolean[num.length], num);
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> item,
			boolean[] used, int[] num) {
		if (item.size() == num.length) {
			ret.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			// note here uses i-1
			if (i > 0 && used[i - 1] == false && num[i] == num[i - 1]) {
				continue;
			}
			if (used[i] == false) {
				used[i] = true;
				item.add(num[i]);
				helper(ret, item, used, num);
				used[i] = false;
				item.remove(item.size() - 1);
			}
		}
	}

	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return ret;
		}
		List<Integer> first = new LinkedList<Integer>();
		first.add(nums[0]);
		ret.add(first);
		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> cur = new LinkedList<List<Integer>>();
			for (int j = 0; j < ret.size(); j++) {
				List<Integer> tmp = ret.get(j);
				for (int k = 0; k <= tmp.size(); k++) {
					List<Integer> list = new LinkedList<Integer>(tmp);
					list.add(k, nums[i]);
					cur.add(list);
					if (k < tmp.size() && tmp.get(k) == nums[i]) {
						break;
					}
				}
			}
			ret = cur;
		}
		return ret;
	}

}
