package problems;

import utilities.TreeNode;

public class LargestBSTSubtree {
	class Result {
		int size;
		int lower;
		int upper;

		Result(int size, int lower, int upper) {
			this.size = size;
			this.lower = lower;
			this.upper = upper;
		}
	}

	int max = 0;

	public int largestBSTSubtree(TreeNode root) {
		traverse(root);
		return max;
	}

	private Result traverse(TreeNode root) {
		if (root == null) {
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		Result left = traverse(root.left);
		Result right = traverse(root.right);
		if (left.size == -1 || right.size == -1 || root.val <= left.upper
				|| root.val >= right.lower) {
			return new Result(-1, 0, 0);
		}
		int size = left.size + 1 + right.size;
		max = Math.max(size, max);
		// Doing Math.min(left.lower, root.val) is because left maybe null
		return new Result(size, Math.min(left.lower, root.val), Math.max(
				right.upper, root.val));
	}

}
