package problems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	/*
	 * ���������ǿ�������������Flood
	 * fill�㷨����������ȸ�����ĿҪ�󣬱�Ե�ϵ�'O'�ǲ���Ҫ���ģ��������ǵİ취�Ƕ��������ұ�Ե��Flood
	 * fill�㷨�������б�Ե�ϵ�'O'���滻����һ���ַ�
	 * ������'#'������������֪����ȥ�����ǻ���'#'����Щ���㣬ʣ�µ�����'O'��Ӧ�ñ��滻��'X'
	 * ����'#'��Щ����Ӧ���ǻ�ԭ��'O'��������ǿ��������һ�α�����Ȼ������Ӧ���ַ��滻�Ϳ����ˡ����Ӷȷ����ϣ������ȶԱ�Ե��Flood
	 * fill�㷨
	 * ����Ϊֻ����'O'�Ż���У����һᱻ�滻��'#'������ÿ�����ı�������ᳬ��һ�Σ������O(m*n)�ĸ��Ӷȣ����һ�α���ͬ����O(m
	 * *n)�������ܵ�ʱ�临�Ӷ���O
	 * (m*n)���ռ��Ͼ��ǵݹ�ջ��������������������Ƕ��У���������������Ŀռ䣬ͬʱ���ڵĿռ�ռ�ò��ᳬ��O(m+n)��
	 * �Թ����������Ϊ����ÿ�ζ����еĽ����Ȼ�����ĸ�������չ
	 * ��������ʵ����Щ�����кܶ��ظ���������е��������������������չ���ᳬ��һ�����Σ�Ҳ����n
	 * /2*2+m/2*2=m+n�������㷨�Ŀռ临�Ӷ���O(m+n)�����������£�
	 */
	public void solve(char[][] board) {
		if (board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}
		for (int i = 0; i < board[0].length; i++) {
			fill(board, 0, i);
			fill(board, board.length - 1, i);
		}
		for (int i = 1; i < board.length - 1; i++) {
			fill(board, i, 0);
			fill(board, i, board[0].length - 1);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	void fill(char[][] board, int i, int j) {
		if (board[i][j] != 'O') {
			return;
		}
		board[i][j] = '#';
		Queue<Integer> queue = new LinkedList<Integer>();
		int code = i * board[0].length + j;
		queue.offer(code);
		while (!queue.isEmpty()) {
			code = queue.poll();
			int row = code / board[0].length;
			int col = code % board[0].length;
			if (row > 0 && board[row - 1][col] == 'O') {
				queue.offer((row - 1) * board[0].length + col);
				board[row - 1][col] = '#';
			}
			if (row < board.length - 1 && board[row + 1][col] == 'O') {
				queue.offer((row + 1) * board[0].length + col);
				board[row + 1][col] = '#';
			}
			if (col > 0 && board[row][col - 1] == 'O') {
				queue.offer(row * board[0].length + col - 1);
				board[row][col - 1] = '#';
			}
			if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
				queue.offer(row * board[0].length + col + 1);
				board[row][col + 1] = '#';
			}
		}
	}
}
