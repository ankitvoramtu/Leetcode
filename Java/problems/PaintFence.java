package problems;

public class PaintFence {
	/*
	 * https://discuss.leetcode.com/topic/23426/o-n-time-java-solution-o-1-space
	 */
	
	public static void main(String[] args) {
		PaintFence a = new PaintFence();
		a.numWays(3, 3);
	}

	public int numWays(int n, int k) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return k;
		int diffColorCounts = k * (k - 1);
		int sameColorCounts = k;
		for (int i = 2; i < n; i++) {
			int temp = diffColorCounts;
			diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
			sameColorCounts = temp;
		}
		return diffColorCounts + sameColorCounts;
	}

}
