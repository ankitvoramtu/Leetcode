package problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		Permutations a = new Permutations();
		System.out.println(a.permute(new int[] { 1, 2, 3 }));
	}

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return ret;
		}
		List<Integer> first = new ArrayList<Integer>();
		first.add(num[0]);
		ret.add(first);
		for (int i = 1; i < num.length; i++) {
			List<List<Integer>> curRet = new ArrayList<List<Integer>>();
			for (int j = 0; j < ret.size(); j++) {
				List<Integer> cur = ret.get(j);
				for (int k = 0; k < cur.size()+1; k++) {
					List<Integer> item = new ArrayList<Integer>(cur);
					item.add(k, num[i]);
					curRet.add(item);
				}
			}
			ret = curRet;
		}
		return ret;
	}

	public List<List<Integer>> permute2(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return ret;
		}
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
			if (used[i] == false) {
				item.add(num[i]);
				used[i] = true;
				helper(ret, item, used, num);
				used[i] = false;
				item.remove(item.size() - 1);
			}

		}
	}
}
