package problems;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0 || str == null
				|| str.length() == 0) {
			return false;
		}
		String[] list = str.split(" ");
		if (pattern.length() != list.length) {
			return false;
		}
		Map<String, Character> map = new HashMap<String, Character>();
		boolean[] used = new boolean[26];
		for (int i = 0; i < list.length; i++) {
			if (!map.containsKey(list[i])) {
				map.put(list[i], pattern.charAt(i));
				if (used[pattern.charAt(i) - 'a']) {
					return false;
				} else {
					used[pattern.charAt(i) - 'a'] = true;
				}
			} else {
				if (map.get(list[i]) != pattern.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

}
