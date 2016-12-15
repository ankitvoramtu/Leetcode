package problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import utilities.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		ret.add(null);
		helper(ret, root);
	}

	private void helper(List<TreeNode> ret, TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode right = root.right;
		if (ret.get(0) != null) {
			ret.get(0).left = null;
			ret.get(0).right = root;
		}
		ret.set(0, root);
		root.right = right;
		helper(ret, root.left);
		helper(ret, right);
	}

	public void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode p = s.pop();
			if (p.right != null) {
				s.push(p.right);
			}
			if (p.left != null) {
				s.push(p.left);
			}
			p.left = null;
			if (!s.isEmpty()) {
				p.right = s.peek();
			}
		}
	}

	public void flatten2(TreeNode root) {
		TreeNode node = root;
		Deque<TreeNode> s = new LinkedList<TreeNode>();
		while (node != null) {
			if (node.right != null) {
				s.push(node.right);
			}
			node.right = node.left;
			node.left = null;
			if (node.right == null && !s.isEmpty()) {
				node.right = s.pop();
			}
			node = node.right;
		}
	}

}
