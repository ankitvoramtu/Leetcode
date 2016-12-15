package problems;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0) {
			return true;
		}
		boolean[] ret = new boolean[s.length() + 1];
		ret[0] = true;
		for (int i = 0; i < s.length(); i++) {
			StringBuilder str = new StringBuilder(s.substring(0, i + 1));
			for (int j = 0; j <= i; j++) {
				if (ret[j] && wordDict.contains(str.toString())) {
					ret[i + 1] = true;
					break;
				}
				str.deleteCharAt(0);
			}
		}
		return ret[s.length()];
	}
}
