package problems;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a']--;
			if (count[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram1(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) < 1) {
				return false;
			}
			map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
		}
		return true;
	}
}
