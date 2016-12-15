package problems;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeNode;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			TreeNode left = n.left;
			n.left = n.right;
			n.right = left;
			if (n.left != null) {
				q.offer(n.left);
			}
			if (n.right != null) {
				q.offer(n.right);
			}
		}
		return root;
	}

	public TreeNode invertTree1(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = invertTree1(root.left);
		TreeNode right = invertTree1(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

}
