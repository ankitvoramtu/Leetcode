package problems;

import java.util.LinkedList;
import java.util.List;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> ret = new LinkedList<String>();
		if (s == null || s.length() < 2) {
			return ret;

		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				String s1 = s.substring(0, i);
				String s2 = "--";
				String s3 = s.substring(i + 2);
				String temp = s1 + s2 + s3;
				ret.add(temp);
			}
		}
		return ret;
	}
}
