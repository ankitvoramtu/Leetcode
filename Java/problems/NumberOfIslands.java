package problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null
				|| grid[0].length == 0) {
			return 0;
		}
		int rLen = grid.length;
		int cLen = grid[0].length;
		int ret = 0;
		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				if (grid[i][j] == '1') {
					ret++;
					helper(grid, i, j);
				}
			}
		}
		return ret;
	}

	public void helper(char[][] grid, int i, int j) {
		int index = i * grid[0].length + j;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(index);
		grid[i][j] = '2';
		while (!q.isEmpty()) {
			index = q.poll();
			int r = index / grid[0].length;
			int c = index % grid[0].length;
			if (r > 0 && grid[r - 1][c] == '1') {
				grid[r - 1][c] = '2';
				q.offer((r - 1) * grid[0].length + c);
			}
			if (r < grid.length - 1 && grid[r + 1][c] == '1') {
				grid[r + 1][c] = '2';
				q.offer((r + 1) * grid[0].length + c);
			}
			if (c > 0 && grid[r][c - 1] == '1') {
				grid[r][c - 1] = '2';
				q.offer(r * grid[0].length + c - 1);
			}
			if (c < grid[0].length - 1 && grid[r][c + 1] == '1') {
				grid[r][c + 1] = '2';
				q.offer(r * grid[0].length + c + 1);
			}
		}
	}

	public int numIslands2(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					merge(grid, i, j);
				}
			}
		}
		return count;
	}

	public void merge(char[][] grid, int i, int j) {
		// validity checking
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
			return;

		// if current cell is water or visited
		if (grid[i][j] != '1')
			return;

		// set visited cell to '2'
		grid[i][j] = '2';

		// merge all adjacent land
		merge(grid, i - 1, j);
		merge(grid, i + 1, j);
		merge(grid, i, j - 1);
		merge(grid, i, j + 1);
	}

}
