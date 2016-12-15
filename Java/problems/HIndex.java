package problems;

import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		int len = citations.length;
		int[] count = new int[len + 1];

		for (int c : citations)
			if (c > len) {
				count[len]++;
			} else {
				count[c]++;
			}

		int total = 0;
		for (int i = len; i >= 0; i--) {
			total += count[i];
			if (total >= i) {
				return i;
			}
		}

		return 0;

	}

	public int hIndex1(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		for (int i = citations.length - 1; i >= 0; i--) {
			int h = citations.length - i;
			if (citations[i] >= h && (i == 0 || citations[i - 1] <= h)) {
				return h;
			}
		}
		return 0;
	}

	public int hIndex2(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int h = 0;
		Arrays.sort(citations);
		for (int i = citations.length - 1; i >= 0; i--) {
			if (citations[i] > h) {
				h++;
			} else {
				return h;
			}
		}
		return h;
	}

}
