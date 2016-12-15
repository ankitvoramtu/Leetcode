package problems;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[] ret = new int[grid[0].length];

		ret[0] = grid[0][0];
		for (int j = 1; j < grid[0].length; j++) {
			ret[j] = ret[j - 1] + grid[0][j];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0) {
					ret[j] = ret[j] + grid[i][j];
				} else {
					ret[j] = Math.min(ret[j - 1], ret[j]) + grid[i][j];
				}
			}
		}
		return ret[grid[0].length - 1];
	}
}
