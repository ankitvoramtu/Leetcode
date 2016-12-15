package problems;

import java.util.Arrays;

public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife a = new GameOfLife();
		int[][] board = new int[1][];
		board[0] = new int[] { 1, 1 };
//		board[1] = new int[] { 1, 0 };
		a.gameOfLife(board);
		System.out.println(Arrays.toString(board[0]));
	}

	// 0 -> 1: 2; 1 -> 0: 3
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int live = count(board, board.length, board[0].length, i, j);
				if (board[i][j] == 0 && live == 3) {
					board[i][j] = 2;
				}
				if (board[i][j] == 1 && (live < 2 || live > 3)) {
					board[i][j] = 3;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 3) {
					board[i][j] = 0;
				} else if (board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
		}
	}

	private int count(int[][] board, int r, int c, int i, int j) {
		int live = 0;
		for (int x = Math.max(0, i - 1); x <= Math.min(r - 1, i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(c - 1, j + 1); y++) {
				if (x == i && y == j) {
					continue;
				}
				if (board[x][y] == 1 || board[x][y] == 3) {
					live++;
				}
			}
		}
		return live;
	}
}
