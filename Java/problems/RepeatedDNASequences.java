package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	/*
	 * The key to solve this problem is that each of the 4 nucleotides can be
	 * stored in 2 bits. So the 10-letter-long sequence can be converted to
	 * 20-bits-long integer. The following is a Java solution. You may use an
	 * example to manually execute the program and see how it works.
	 */

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ret = new LinkedList<String>();
		if (s == null || s.length() == 0) {
			return ret;
		}
		Set<Integer> words = new HashSet<Integer>();
		Set<Integer> doubleWords = new HashSet<Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		for (int i = 0; i < s.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v = v << 2;
				v += map.get(s.charAt(j));
			}
			if (!words.add(v) && doubleWords.add(v)) {
				ret.add(s.substring(i, i + 10));
			}
		}
		return ret;
	}
}
