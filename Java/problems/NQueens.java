package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		NQueens a = new NQueens();
		List<String[]> ret = a.solveNQueens(4);
		a.print(ret);
	}

	public void print(List<String[]> ret) {
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(Arrays.toString(ret.get(i)));
		}
	}

	public List<String[]> solveNQueens(int n) {
		List<String[]> ret = new ArrayList<String[]>();
		if (n <= 0) {
			return ret;
		}
		helper(n, 0, new int[n], ret);
		return ret;
	}

	private void helper(int n, int row, int[] columnForRow, List<String[]> ret) {
		if (row == n) {
			String[] str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = "";
				for (int j = 0; j < n; j++) {
					if (columnForRow[i] != j) {
						str[i] += '.';
					} else {
						str[i] += 'Q';
					}
				}
			}
			ret.add(str);
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
