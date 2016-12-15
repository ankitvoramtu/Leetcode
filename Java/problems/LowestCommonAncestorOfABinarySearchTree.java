package problems;

import utilities.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val > p.val && root.val > q.val)
				root = root.left;
			else if (root.val < p.val && root.val < q.val)
				root = root.right;
			else
				return root;
		}
		return null;
	}

}
