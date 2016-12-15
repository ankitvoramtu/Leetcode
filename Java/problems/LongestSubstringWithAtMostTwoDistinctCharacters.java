package problems;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters a = new LongestSubstringWithAtMostTwoDistinctCharacters();
		a.lengthOfLongestSubstringTwoDistinct("aabaabcccaabab");

	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] count = new int[256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0) {
				numDistinct++;
			}
			count[s.charAt(j)]++;
			while (numDistinct > 2) {
				count[s.charAt(i)]--;
				if (count[s.charAt(i)] == 0) {
					numDistinct--;
				}
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

	/*
	 * 最优的解法应该是维护一个sliding window，指针变量i指向sliding window的起始位置，j指向另个一个字符在sliding
	 * window的最后一个，用于定位i的下一个跳转位置。内部逻辑就是 1）如果当前字符跟前一个字符是一样的，直接继续。
	 * 2）如果不一样，则需要判断当前字符跟j是不是一样的 a）一样的话sliding window左边不变，右边继续增加，但是j的位置需要调整到k-1。
	 * b）不一样的话，sliding window的左侧变为j的下一个字符（也就是去掉包含j指向的字符的区间），j的位置也需要调整到k-1。
	 * 
	 * 在对i进行调整的时候（1.a），需要更新maxLen。
	 * 
	 * [注意事项] 1）在最后返回的时候，注意考虑s.length()-i这种情况，也就是字符串读取到最后而没有触发（1.a）
	 * 2）讲解清楚sliding window的更新 3）该题目有个follow-up，就是如果是k个distinct
	 * characters怎么办。这样的话就只能对所有可能的字符用一个数组去做counting，而且只能假设ASIC字符集256。Unicode太大了。
	 */

	public int lengthOfLongestSubstringTwoDistinct1(String s) {
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1))
				continue;
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			j = k - 1;
		}
		return Math.max(s.length() - i, maxLen);
	}
}
