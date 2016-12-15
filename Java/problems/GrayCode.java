package problems;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> ret = new LinkedList<Integer>();
		if (n < 0) {
			return ret;
		}
		ret.add(0);
		for (int i = 0; i < n; i++) {
			int sz = ret.size();
			for (int j = sz - 1; j >= 0; j--) {
				ret.add(ret.get(j) + (1 << i));
			}
		}
		return ret;
	}
}
