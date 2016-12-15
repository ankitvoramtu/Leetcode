package problems;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int l = 0;
		int r = matrix.length - 1;
		boolean findRow = false;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (matrix[mid][0] <= target
					&& matrix[mid][matrix[0].length - 1] >= target) {
				findRow = true;
				break;
			}
			if (matrix[mid][0] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		int row;
		if (findRow) {
			row = (l + r) / 2;
		} else {
			return false;
		}
		l = 0;
		r = matrix[0].length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (matrix[row][mid] == target) {
				return true;
			} else if (matrix[row][mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}

	public boolean searchMatrix1(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		int left = 0;
		int right = r * c - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (matrix[mid / c][mid % c] == target) {
				return true;
			} else if (matrix[mid / c][mid % c] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
