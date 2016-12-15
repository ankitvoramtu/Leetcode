package problems;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0) {
			return 0;
		}
		int[] ret = new int[obstacleGrid[0].length];
		ret[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					ret[j] = 0;
				} else {
					if (j > 0) {
						ret[j] = ret[j - 1] + ret[j];
					}
				}
			}
		}
		return ret[obstacleGrid[0].length - 1];
	}
}
