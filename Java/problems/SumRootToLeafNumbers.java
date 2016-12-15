package problems;

import utilities.TreeNode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return sum * 10 + root.val;
		}
		return helper(root.left, sum * 10 + root.val)
				+ helper(root.right, sum * 10 + root.val);
	}
}