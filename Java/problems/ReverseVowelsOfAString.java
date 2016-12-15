package problems;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		char[] c = s.toCharArray();
		int l = 0;
		int r = c.length - 1;

		while (l <= r) {
			while (l <= r && !set.contains(c[l])) {
				l++;
			}
			while (l <= r && !set.contains(c[r])) {
				r--;
			}
			char tmp = c[l];
			c[l] = c[r];
			c[r] = tmp;
		}
		return new String(c);

	}
}
