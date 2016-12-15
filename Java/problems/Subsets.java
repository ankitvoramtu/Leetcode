package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		Subsets a = new Subsets();
		System.out.println(a.subsets(new int[] { 2, 3, 4 }));
	}

	// Recursives
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0) {
			return ret;
		}
		ret.add(new ArrayList<Integer>());
		Arrays.sort(S);
		helper(ret, S, 0);
		return ret;
	}

	public void helper(List<List<Integer>> ret, int[] num, int index) {
		if (index == num.length) {
			return;
		}
		int size = ret.size();
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> item = new ArrayList<Integer>(ret.get(i));
			item.add(num[index]);
			ret.add(item);
		}
		helper(ret, num, index + 1);

	}

	// Iterative
	public List<List<Integer>> subsets1(int[] S) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0) {
			return ret;
		}
		ret.add(new ArrayList<Integer>());
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			int size = ret.size();
			for (int j = 0; j < size; j++) {
				List<Integer> item = new ArrayList<Integer>(ret.get(j));
				item.add(S[i]);
				ret.add(item);
			}
		}
		return ret;
	}
}
