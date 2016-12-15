package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
	public static void main(String[] args) {
		MinimumHeightTrees a = new MinimumHeightTrees();
		a.findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } });
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ret = new LinkedList<Integer>();
		if (n < 1) {
			return ret;
		}
		if (n == 1) {
			ret.add(0);
			return ret;
		}
		// Note ArrayList is needed, not LinkedList
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		for (int i = 0; i < n; i++) {
			list.add(new HashSet<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			list.get(edges[i][1]).add(edges[i][0]);
		}
		for (int i = 0; i < n; i++) {
			if (list.get(i).size() == 1) {
				ret.add(i);
			}
		}
		while (n > 2) {
			n = n - ret.size();
			List<Integer> cur = new LinkedList<Integer>();
			for (int i = 0; i < ret.size(); i++) {
				int j = list.get(ret.get(i)).iterator().next();
				list.get(j).remove(ret.get(i));
				if (list.get(j).size() == 1) {
					cur.add(j);
				}
			}
			ret = cur;
		}
		return ret;
	}

}
