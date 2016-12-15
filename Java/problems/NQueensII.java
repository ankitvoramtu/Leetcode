package problems;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	public int totalNQueens(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		;
		ret.add(0);
		if (n <= 0) {
			return 0;
		}
		helper(n, 0, new int[n], ret);
		return ret.get(0);
	}

	private void helper(int n, int row, int[] columnForRow, List<Integer> ret) {
		if (row == n) {
			ret.set(0, ret.get(0) + 1);
			return;
		}
		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (check(row, columnForRow)) {
				helper(n, row + 1, columnForRow, ret);
			}
		}
	}

	private boolean check(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if ((row - i == Math.abs(columnForRow[row] - columnForRow[i]))
					|| (columnForRow[row] == columnForRow[i])) {
				return false;
			}
		}
		return true;
	}
}
