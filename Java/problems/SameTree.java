package problems;

import java.util.Stack;

import utilities.TreeNode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(p);
		s.push(q);
		while (!s.isEmpty()) {
			p = s.pop();
			q = s.pop();
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
			s.push(q.left);
			s.push(p.right);
			s.push(q.right);
		}
		return true;
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}
}
