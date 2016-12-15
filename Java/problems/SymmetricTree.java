package problems;

import java.util.Stack;

import utilities.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root.left);
		s.push(root.right);
		while (!s.isEmpty()) {
			TreeNode p = s.pop();
			TreeNode q = s.pop();
			if (p == null && q == null) {
				continue;
			}
			if (p == null || q == null) {
				return false;
			}
			if (p.val != q.val) {
				return false;
			}
			s.push(p.left);
			s.push(q.right);
			s.push(p.right);
			s.push(q.left);
		}
		return true;
	}

	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val && helper(left.left, right.right)
				&& helper(left.right, right.left);
	}
}
