package problems;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null) {
			return 0;
		}
		if (t.length() == 0) {
			return 1;
		}
		if (s.length() == 0) {
			return 0;
		}
		int[] ret = new int[t.length() + 1];
		ret[0] = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = t.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == t.charAt(j)) {
					ret[j + 1] = ret[j + 1] + ret[j];
				} else {
					ret[j + 1] = ret[j + 1];
				}
			}
		}
		return ret[t.length()];
	}
}
