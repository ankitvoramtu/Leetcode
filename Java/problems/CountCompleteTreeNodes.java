package problems;

import utilities.TreeNode;

public class CountCompleteTreeNodes {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Solution {
		public int countNodes1(TreeNode root) {
			int h = height1(root) - 1;
			int ret = 0;
			while (root != null) {
				if (height1(root.left) == height1(root.right)) {
					ret += 1 << h;
					root = root.right;
				} else {
					ret += 1 << (h - 1);
					root = root.left;
				}
				h--;
			}
			return ret;
		}

		private int height1(TreeNode root) {
			int ret = 0;
			while (root != null) {
				ret++;
				if (root.left == null) {
					return ret;
				} else {
					root = root.left;
				}
			}
			return ret;
		}
	}

	public int countNodes(TreeNode root) {
		int h = height(root) - 1;
		int ret = 0;
		while (root != null) {
			if (height(root.left) == height(root.right)) {
				ret += 1 << h;
				root = root.right;
			} else {
				ret += 1 << (h - 1);
				root = root.left;
			}
			h--;
		}
		return ret;
	}

	private int height(TreeNode root) {
		int ret = 0;
		while (root != null) {
			ret++;
			if (root.left == null) {
				return ret;
			} else {
				root = root.left;
			}
		}
		return ret;
	}
}
