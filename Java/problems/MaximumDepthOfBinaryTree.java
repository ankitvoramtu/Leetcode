package problems;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeNode;

public class MaximumDepthOfBinaryTree {
	public int maxDepth1(TreeNode root) {
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

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
