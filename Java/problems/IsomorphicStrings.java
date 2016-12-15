package problems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		int len = s.length();
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		for (int i = 0; i < 256; i++) {
			m1[i] = m2[i] = -1;
		}

		for (int i = 0; i < len; i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			m1[s.charAt(i)] = m2[t.charAt(i)] = i;
		}
		return true;
	}

	public boolean isIsomorphic2(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		if (s.length() == 0 || t.length() == 0) {
			return true;
		}

		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (map.containsKey(sc)) {
				if (map.get(sc) != tc) {
					return false;
				}
			} else {
				if (map.containsValue(tc)) {
					return false;
				} else {
					map.put(sc, tc);
				}
			}
		}
		return true;
	}
}
