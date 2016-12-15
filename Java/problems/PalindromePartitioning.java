package problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return ret;
		helper(s, getDict(s), 0, new ArrayList<String>(), ret);
		return ret;
	}

	private void helper(String s, boolean[][] dict, int start,
			List<String> item, List<List<String>> ret) {
		if (start == s.length()) {
			ret.add(new ArrayList<String>(item));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (dict[start][i]) {
				item.add(s.substring(start, i + 1));
				helper(s, dict, i + 1, item, ret);
				item.remove(item.size() - 1);
			}
		}
	}

	private boolean[][] getDict(String s) {
		boolean[][] dict = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)
						&& ((j - i < 2) || dict[i + 1][j - 1])) {
					dict[i][j] = true;
				}
			}
		}
		return dict;
	}
}
