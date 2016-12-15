package problems;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	/*
	 * As it turns out, if we could add two ¡°artificial¡± elements, ¨C1 before the
	 * first element and 100 after the last element, we could avoid all the
	 * above pesky cases.
	 */
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList<>();
		int prev = start - 1;
		for (int i = 0; i <= vals.length; i++) {
			int curr = (i == vals.length) ? end + 1 : vals[i];
			if (curr - prev >= 2) {
				ranges.add(getRange(prev + 1, curr - 1));
			}
			prev = curr;
		}
		return ranges;
	}

	private String getRange(int from, int to) {
		return (from == to) ? String.valueOf(from) : from + "->" + to;
	}
}
