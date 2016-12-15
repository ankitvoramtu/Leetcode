package problems;

import utilities.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		return helper(num, 0, num.length - 1);
	}

	private TreeNode helper(int[] num, int l, int r) {
		if (l > r) {
			return null;
		}
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, l, mid - 1);
		root.right = helper(num, mid + 1, r);
		return root;
	}
}
