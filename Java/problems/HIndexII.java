package problems;

public class HIndexII {
	public int hIndex(int[] citations) {
		int len = citations.length;
		int l = 0;
		int r = len - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (citations[m] < len - m) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return len - l;
	}

}
