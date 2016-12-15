package problems;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring a = new LongestPalindromicSubstring();
		// System.out.println(a.longestPalindrome("bb"));
		System.out.println(a.longestPalindrome("abcbe"));
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		boolean[][] palin = new boolean[s.length()][s.length()];
		String res = "";
		int maxLen = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 2 || palin[i + 1][j - 1])) {
					palin[i][j] = true;
					if (maxLen < j - i + 1) {
						maxLen = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}

	public String longestPalindrome1(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public String longestPalindrome2(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int len = s.length();
		int maxLen = 0;
		int maxLeft = 0;
		int maxRight = 0;
		int curLen = 0;
		int prev;
		int next;
		for (int i = 0; i < len * 2 - 1; i++) {
			if (i % 2 == 0) {
				curLen = 1;
				prev = (i / 2 - 1);
				next = (i / 2 + 1);
			} else {
				curLen = 0;
				prev = (i / 2);
				next = (i / 2 + 1);
			}
			for (; prev >= 0 && next < len; prev--, next++) {
				if (s.charAt(prev) == s.charAt(next)) {
					curLen += 2;
				} else {
					break;
				}
			}
			if (curLen > maxLen) {
				maxLen = curLen;
				maxLeft = prev + 1;
				maxRight = next;
			}
		}
		return s.substring(maxLeft, maxRight);
	}
}
