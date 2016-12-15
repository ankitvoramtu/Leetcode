package problems;

public class EditDistance {
	public static void main(String[] args) {
		EditDistance a = new EditDistance();
		System.out.println(a.minDistance("a", "a"));
		System.out.println(a.minDistance("distance", "springbok"));
	}

	public int minDistance(String word1, String word2) {
		if (word1.length() == 0) {
			return word2.length();
		}
		if (word2.length() == 0) {
			return word1.length();
		}
		int n = word1.length();
		int m = word2.length();
		int[] ret = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			ret[i] = i;
		}
		for (int i = 0; i < n; i++) {
			int[] cur = new int[m + 1];
			cur[0] = i + 1;
			for (int j = 0; j < m; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					cur[j + 1] = ret[j];
				} else {
					cur[j + 1] = Math.min(cur[j], Math.min(ret[j], ret[j + 1])) + 1;
				}
			}
			ret = cur;
		}
		return ret[m];
	}
}
