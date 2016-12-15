package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utilities.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				ret.add(root.val);
				if (root.right != null) {
					s.push(root.right);
				}
				root = root.left;
			} else {
				root = s.pop();
			}
		}
		return ret;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				ret.add(root.val);
				root = root.left;
			} else {
				root = s.pop();
				root = root.right;
			}
		}
		return ret;
	}

	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root == null) {
			return ret;
		}
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			ret.add(node.val);
			if (node.right != null) {
				s.push(node.right);
			}
			if (node.left != null) {
				s.push(node.left);
			}
		}
		return ret;
	}

	public List<Integer> preorderTraversal4(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		preorderTraversalRecursive(root, ret);
		return ret;
	}

	private void preorderTraversalRecursive(TreeNode root, List<Integer> ret) {
		if (root == null) {
			return;
		}
		ret.add(root.val);
		preorderTraversalRecursive(root.left, ret);
		preorderTraversalRecursive(root.right, ret);
	}
}
