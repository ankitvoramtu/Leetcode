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
	 * ���ŵĽⷨӦ����ά��һ��sliding window��ָ�����iָ��sliding window����ʼλ�ã�jָ�����һ���ַ���sliding
	 * window�����һ�������ڶ�λi����һ����תλ�á��ڲ��߼����� 1�������ǰ�ַ���ǰһ���ַ���һ���ģ�ֱ�Ӽ�����
	 * 2�������һ��������Ҫ�жϵ�ǰ�ַ���j�ǲ���һ���� a��һ���Ļ�sliding window��߲��䣬�ұ߼������ӣ�����j��λ����Ҫ������k-1��
	 * b����һ���Ļ���sliding window������Ϊj����һ���ַ���Ҳ����ȥ������jָ����ַ������䣩��j��λ��Ҳ��Ҫ������k-1��
	 * 
	 * �ڶ�i���е�����ʱ��1.a������Ҫ����maxLen��
	 * 
	 * [ע������] 1������󷵻ص�ʱ��ע�⿼��s.length()-i���������Ҳ�����ַ�����ȡ������û�д�����1.a��
	 * 2���������sliding window�ĸ��� 3������Ŀ�и�follow-up�����������k��distinct
	 * characters��ô�졣�����Ļ���ֻ�ܶ����п��ܵ��ַ���һ������ȥ��counting������ֻ�ܼ���ASIC�ַ���256��Unicode̫���ˡ�
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
