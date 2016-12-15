package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords a = new SubstringWithConcatenationOfAllWords();
		System.out.println(a.findSubstring(
				"lingmindraboofooowingdingbarrwingmonkeypoundcake",
				new String[] { "fooo", "barr", "wing", "ding", "wing" }));
	}

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ret = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return ret;
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (map.containsKey(L[i])) {
				map.put(L[i], map.get(L[i]) + 1);
			} else {
				map.put(L[i], 1);
			}
		}
		int len = L[0].length();
		for (int i = 0; i < len; i++) {
			HashMap<String, Integer> curMap = new HashMap<String, Integer>();
			int count = 0;
			int left = i;
			for (int j = i; j <= S.length() - len; j += len) {
				String str = S.substring(j, j + len);
				if (map.containsKey(str)) {
					if (curMap.containsKey(str)) {
						curMap.put(str, curMap.get(str) + 1);
					} else {
						curMap.put(str, 1);
					}
					if (curMap.get(str) <= map.get(str)) {
						count++;
					} else {
						while (curMap.get(str) > map.get(str)) {
							String temp = S.substring(left, left + len);
							if (curMap.containsKey(temp)) {
								curMap.put(temp, curMap.get(temp) - 1);
								if (curMap.get(temp) < map.get(temp)) {
									count--;
								}
								left += len;
							}
						}
					}
					if (count == L.length) {
						ret.add(left);
						String temp = S.substring(left, left + len);
						if (curMap.containsKey(temp)) {
							curMap.put(temp, curMap.get(temp) - 1);
						}
						count--;
						left += len;

					}
				} else {
					curMap.clear();
					count = 0;
					left = j + len;
				}
			}
		}
		return ret;
	}
}
