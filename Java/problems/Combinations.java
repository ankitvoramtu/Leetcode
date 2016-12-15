package problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args) {
		Combinations a = new Combinations();
		List<List<Integer>> ret = a.combine(4, 2);
		System.out.println(ret);
	}

	// Iterative
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (n < k || n < 1) {
			return ret;
		}
		List<List<Integer>> prev = new ArrayList<List<Integer>>();
		for (int i = 1; i <= n - k + 1; i++) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			b.add(i);
			prev.add(b);
		}
		ret = new ArrayList<List<Integer>>(prev);
		for (int i = 1; i < k; i++) {
			prev = new ArrayList<List<Integer>>();
			for (List<Integer> temp : ret) {
				int a = temp.get(temp.size() - 1);
				for (int j = a + 1; j <= n - k + 1 + i; j++) {
					ArrayList<Integer> b = new ArrayList<Integer>(temp);
					b.add(j);
					prev.add(b);
				}
			}
			ret = new ArrayList<List<Integer>>(prev);
		}

		return ret;

	}

	// Recursive
	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (n < k || n < 1) {
			return ret;
		}

		helper(ret, new ArrayList<Integer>(), 1, n, k);
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> item, int start,
			int n, int k) {
		if (item.size() == k) {
			ret.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i <= n; i++) {
			item.add(i);
			helper(ret, item, i + 1, n, k);
			item.remove(item.size() - 1);
		}
	}
}
