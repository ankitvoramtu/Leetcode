package problems;

import utilities.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		int[] lens = new int[1];
		if (root == null) {
			return 0;
		}
		helper(root, 0, lens, root.val);
		return lens[0];
	}

	private void helper(TreeNode root, int cur, int[] cnt, int target) {
		if (root == null) {
			return;
		}
		if (root.val == target) {
			cur++;
		} else {
			cur = 1;
		}
		cnt[0] = Math.max(cur, cnt[0]);
		helper(root.left, cur, cnt, root.val + 1);
		helper(root.right, cur, cnt, root.val + 1);
	}

}
