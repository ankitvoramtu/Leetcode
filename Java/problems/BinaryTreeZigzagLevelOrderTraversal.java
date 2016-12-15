package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utilities.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Deque<TreeNode> s = new LinkedList<TreeNode>();
		s.push(root);
		int level = 0;
		List<Integer> list = new LinkedList<Integer>();
		Deque<TreeNode> s2 = new LinkedList<TreeNode>();
		while (!s.isEmpty()) {
			TreeNode n = s.pop();
			list.add(n.val);
			if (level % 2 == 0) {
				if (n.left != null) {
					s2.push(n.left);
				}
				if (n.right != null) {
					s2.push(n.right);
				}
			} else {
				if (n.right != null) {
					s2.push(n.right);
				}
				if (n.left != null) {
					s2.push(n.left);
				}
			}
			if (s.isEmpty()) {
				ret.add(list);
				list = new LinkedList<Integer>();
				s = s2;
				s2 = new LinkedList<TreeNode>();
				level++;
			}
		}
		return ret;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Deque<TreeNode> pre = new LinkedList<TreeNode>();
		pre.push(root);
		int level = 1;
		while (!pre.isEmpty()) {
			Deque<TreeNode> cur = new LinkedList<TreeNode>();
			List<Integer> list = new LinkedList<Integer>();
			while (!pre.isEmpty()) {
				TreeNode node = pre.pop();
				list.add(node.val);
				if (level % 2 == 0) {
					if (node.right != null) {
						cur.push(node.right);
					}
					if (node.left != null) {
						cur.push(node.left);
					}
				} else {
					if (node.left != null) {
						cur.push(node.left);
					}
					if (node.right != null) {
						cur.push(node.right);
					}
				}
			}
			level++;
			pre = cur;
			ret.add(list);
		}
		return ret;
	}
}
