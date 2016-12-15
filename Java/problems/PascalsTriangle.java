package problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (numRows < 1) {
			return ret;
		}
		List<Integer> preList = new ArrayList<Integer>();
		preList.add(1);
		ret.add(preList);
		for (int i = 2; i <= numRows; i++) {
			List<Integer> curList = new ArrayList<Integer>();
			curList.add(1);
			for (int j = 1; j < i - 1; j++) {
				curList.add(preList.get(j - 1) + preList.get(j));
			}
			curList.add(1);
			ret.add(curList);
			preList = curList;
		}
		return ret;
	}
}
