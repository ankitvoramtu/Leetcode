package problems;

public class InterleavingString {
	/*
	 * 先说说维护量，res[i][j]表示用s1的前i个字符和s2的前j个字符能不能按照规则表示出s3的前i+j个字符，如此最后结果就是res[s1.
	 * length
	 * ()][s2.length()]，判断是否为真即可。接下来就是递推式了，假设知道res[i][j]之前的所有历史信息，我们怎么得到res
	 * [i][j]
	 * 。可以看出，其实只有两种方式来递推，一种是选取s1的字符作为s3新加进来的字符，另一种是选s2的字符作为新进字符。而要看看能不能选取，就是判断s1
	 * (
	 * s2)的第i(j)个字符是否与s3的i+j个字符相等。如果可以选取并且对应的res[i-1][j](res[i][j-1])也为真，就说明s3的i
	 * +j个字符可以被表示。这两种情况只要有一种成立，就说明res[i][j]为真，是一个或的关系。所以递推式可以表示成 res[i][j] =
	 * res[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1) ||
	 * res[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)
	 * 时间上因为是一个二维动态规划，所以复杂度是O(m*n)，
	 * m和n分别是s1和s2的长度。最后就是空间花费，可以看出递推式中只需要用到上一行的信息，所以我们只需要一个一维数组就可以完成历史信息的维护
	 * ，为了更加优化，我们把短的字符串放在内层循环，这样就可以只需要短字符串的长度即可，所以复杂度是O(min(m,n))。
	 */

	public boolean isInterleave2(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l3 != l1 + l2) {
			return false;
		}
		boolean[][] ret = new boolean[l1 + 1][l2 + 1];
		ret[0][0] = true;
		for (int j = 0; j < l2; j++) {
			ret[0][j + 1] = ret[0][j] && s2.charAt(j) == s3.charAt(j);
		}
		for (int i = 0; i < l1; i++) {
			ret[i + 1][0] = ret[i][0] && s1.charAt(i) == s3.charAt(i);
		}

		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				ret[i + 1][j + 1] = (ret[i + 1][j] && s2.charAt(j) == s3
						.charAt(i + j + 1))
						|| (ret[i][j + 1] && s1.charAt(i) == s3.charAt(i + j
								+ 1));
			}
		}

		return ret[l1][l2];

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		String minWord = s1.length() > s2.length() ? s2 : s1;
		String maxWord = s1.length() > s2.length() ? s1 : s2;
		boolean[] ret = new boolean[minWord.length() + 1];
		ret[0] = true;
		for (int i = 0; i < minWord.length(); i++) {
			ret[i + 1] = ret[i] && minWord.charAt(i) == s3.charAt(i);
		}
		for (int i = 0; i < maxWord.length(); i++) {
			ret[0] = ret[0] && maxWord.charAt(i) == s3.charAt(i);
			for (int j = 0; j < minWord.length(); j++) {
				ret[j + 1] = ret[j + 1]
						&& maxWord.charAt(i) == s3.charAt(i + j + 1) || ret[j]
						&& minWord.charAt(j) == s3.charAt(i + j + 1);
			}
		}
		return ret[minWord.length()];
	}

}
