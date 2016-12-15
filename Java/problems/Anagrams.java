package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		System.out.println(a.groupAnagrams(new String[] { "abc", "ac", "ca",
				"bb", "cba" }));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ret = new LinkedList<List<String>>();
		if (strs == null || strs.length == 0) {
			return ret;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if (map.containsKey(key)) {
				map.get(key).add(strs[i]);
			} else {
				List<String> list = new LinkedList<String>();
				list.add(strs[i]);
				map.put(key, list);
			}
		}
		for (List<String> value : map.values()) {
			Collections.sort(value);
			ret.add(value);
		}
		return ret;
	}
}
