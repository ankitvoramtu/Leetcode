package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "aaa";
		LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(a.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		int maxLen = 0;
		int l = 0;
		for (int r = 0; r < s.length(); r++) {
			int index = s.charAt(r);
			if (arr[index] >= l) {
				l = arr[index] + 1;
			}
			arr[index] = r;
			maxLen = Math.max(r - l + 1, maxLen);
		}
		return maxLen;
	}

	public int lengthOfLongestSubstring1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<Character>();
		int ret = 0;
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				while (s.charAt(l) != c) {
					set.remove(s.charAt(l++));
				}
				set.remove(s.charAt(l++));
			}
			set.add(c);
			ret = Math.max(ret, i - l + 1);
		}
		return ret;
	}
}
