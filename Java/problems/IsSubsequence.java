package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		int indexS = 0;
		int indexT = 0;
		while (indexT < t.length()) {
			if (t.charAt(indexT) == s.charAt(indexS)) {
				indexS++;
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		return false;

	}

	// Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
	// Eg-1. s="abc", t="bahbgdca"
	// idx=[a={1,7}, b={0,3}, c={6}]
	// i=0 ('a'): prev=1
	// i=1 ('b'): prev=3
	// i=2 ('c'): prev=6 (return true)
	// Eg-2. s="abc", t="bahgdcb"
	// idx=[a={1}, b={0,6}, c={5}]
	// i=0 ('a'): prev=1
	// i=1 ('b'): prev=6
	// i=2 ('c'): prev=? (return false)
	public boolean isSubsequence2(String s, String t) {
		List<Integer>[] idx = new List[256]; // Just for clarity
		for (int i = 0; i < t.length(); i++) {
			if (idx[t.charAt(i)] == null)
				idx[t.charAt(i)] = new ArrayList<Integer>();
			idx[t.charAt(i)].add(i);
		}

		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			if (idx[s.charAt(i)] == null)
				return false; // Note: char of S does NOT exist in T causing NPE
			int j = Collections.binarySearch(idx[s.charAt(i)], prev);
			if (j < 0)
				j = -j - 1;
			if (j == idx[s.charAt(i)].size())
				return false;
			prev = idx[s.charAt(i)].get(j) + 1;
		}
		return true;
	}

}
