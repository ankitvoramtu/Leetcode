package problems;

import java.util.Deque;
import java.util.LinkedList;

import utilities.TreeNode;

public class KthSmallestElementInABST {
	class TreeNodeWithCount {
		int val;
		int count;
		TreeNodeWithCount left;
		TreeNodeWithCount right;

		TreeNodeWithCount(int x) {
			val = x;
			count = 1;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
		return kthSmallest(rootWithCount, k);
	}

	public TreeNodeWithCount buildTreeWithCount(TreeNode root) {
		if (root == null)
			return null;
		TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
		rootWithCount.left = buildTreeWithCount(root.left);
		rootWithCount.right = buildTreeWithCount(root.right);
		if (rootWithCount.left != null)
			rootWithCount.count += rootWithCount.left.count;
		if (rootWithCount.right != null)
			rootWithCount.count += rootWithCount.right.count;
		return rootWithCount;
	}

	public int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
		if (k <= 0 || k > rootWithCount.count) {
			return -1;
		}
		if (rootWithCount.left != null) {
			if (rootWithCount.left.count == k - 1) {
				return rootWithCount.val;
			} else if (rootWithCount.left.count > k - 1) {
				return kthSmallest(rootWithCount.left, k);
			} else {
				return kthSmallest(rootWithCount.right, k - 1
						- rootWithCount.left.count);

			}
		} else {
			if (k == 1) {
				return rootWithCount.val;
			} else {
				return kthSmallest(rootWithCount.right, k - 1);

			}
		}
	}

	public int kthSmallest2(TreeNode root, int k) {
		Deque<TreeNode> s = new LinkedList<TreeNode>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				TreeNode n = s.pop();
				k--;
				if (k == 0) {
					return n.val;
				}
				root = n.right;
			}
		}
		return 0;
	}

}
