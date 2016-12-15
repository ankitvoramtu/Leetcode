package problems;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		for (int index = 0; index < strs[0].length(); index++) {
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].length() <= index
						|| strs[i].charAt(index) != strs[0].charAt(index)) {
					return strs[0].substring(0, index);
				}
			}
		}
		return strs[0];
	}
}
