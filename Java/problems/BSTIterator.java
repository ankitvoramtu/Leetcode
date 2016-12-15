package problems;

import java.util.Deque;
import java.util.LinkedList;

import utilities.TreeNode;

public class BSTIterator {

	Deque<TreeNode> s;
	TreeNode node;

	public BSTIterator(TreeNode root) {
		s = new LinkedList<TreeNode>();
		node = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty() || node != null;
	}

	/** @return the next smallest number */
	public int next() {
		int ret;
		while (!s.isEmpty() || node != null) {
			if (node != null) {
				s.push(node);
				node = node.left;
			} else {
				node = s.pop();
				ret = node.val;
				node = node.right;
				return ret;
			}
		}
		return 0;
	}
}
