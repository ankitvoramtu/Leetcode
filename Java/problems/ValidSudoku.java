package problems;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0] == null
				|| board[0].length != 9) {
			return false;
		}
		int n = 9;
		for (int i = 0; i < n; i++) {
			boolean[] map = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (board[i][j] != '.') {
					if (map[board[i][j] - '1']) {
						return false;
					}
					map[board[i][j] - '1'] = true;
				}
			}
		}
		for (int j = 0; j < n; j++) {
			boolean[] map = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (board[i][j] != '.') {
					if (map[board[i][j] - '1']) {
						return false;
					}
					map[board[i][j] - '1'] = true;
				}
			}
		}
		for (int block = 0; block < n; block++) {
			boolean[] map = new boolean[n];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (map[board[i][j] - '1']) {
							return false;
						}
						map[board[i][j] - '1'] = true;
					}
				}
			}

		}
		return true;
	}
}
