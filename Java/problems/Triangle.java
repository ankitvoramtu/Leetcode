package problems;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() <= 0) {
			return 0;
		}
		int size = triangle.size();
		int[] ret = new int[size];
		for (int i = 0; i < size; i++) {
			ret[i] = triangle.get(size - 1).get(i);
		}
		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				ret[j] = Math.min(ret[j], ret[j + 1]) + triangle.get(i).get(j);
			}
		}
		return ret[0];
	}
}
