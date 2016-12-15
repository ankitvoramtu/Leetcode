package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utilities.NestedInteger;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}

		int ret = 0;
		int level = 1;

		Deque<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
		while (queue.size() > 0) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.poll();

				if (ni.isInteger()) {
					ret += ni.getInteger() * level;
				} else {
					queue.addAll(ni.getList());
				}
			}

			level++;
		}

		return ret;
	}

	public int depthSum1(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}

	private int helper(List<NestedInteger> list, int depth) {
		int ret = 0;
		for (NestedInteger e : list) {
			ret += e.isInteger() ? e.getInteger() * depth : helper(e.getList(),
					depth + 1);
		}
		return ret;
	}

}
