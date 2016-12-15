package problems;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeNode;

public class MinimumDepthOfBinaryTree {
	/*
	 * 这道题是树的题目，其实跟Maximum Depth of Binary
	 * Tree非常类似，只是这道题因为是判断最小深度，所以必须增加一个叶子的判断（
	 * 因为如果一个节点如果只有左子树或者右子树，我们不能取它左右子树中小的作为深度
	 * ，因为那样会是0，我们只有在叶子节点才能判断深度，而在求最大深度的时候，因为一定会取大的那个，所以不会有这个问题）
	 */
	public int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int curNum = 0;
		int preNum = 1;
		int level = 0;

		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			preNum--;
			if (cur.left == null && cur.right == null) {
				return level + 1;
			}
			if (cur.left != null) {
				q.offer(cur.left);
				curNum++;
			}
			if (cur.right != null) {
				q.offer(cur.right);
				curNum++;
			}
			if (preNum == 0) {
				level++;
				preNum = curNum;
				curNum = 0;
			}
		}
		return level;
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}