package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.TreeNode;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int pre = 1;
		int cur = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			pre--;
			if (node.left != null) {
				q.offer(node.left);
				cur++;
			}
			if (node.right != null) {
				q.offer(node.right);
				cur++;
			}
			if (pre == 0) {
				ret.add(node.val);
				pre = cur;
				cur = 0;
			}
		}
		return ret;
	}
}
