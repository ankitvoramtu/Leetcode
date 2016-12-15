package problems;

import utilities.TreeNode;

public class BinaryTreeUpsideDown {
	public static void main(String[] args) {
		BinaryTreeUpsideDown a = new BinaryTreeUpsideDown();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode ret = a.UpsideDownBinaryTree(root);
		System.out.println(ret);

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode ret2 = a.UpsideDownBinaryTree2(root);
		System.out.println(ret2);

	}

	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		TreeNode p = root, parent = null, parentRight = null;
		while (p != null) {
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}

	public TreeNode UpsideDownBinaryTree2(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		} else {
			TreeNode left = root.left;
			TreeNode right = root.right;
			TreeNode newNode = UpsideDownBinaryTree(root.left);
			left.left = right;
			left.right = root;
			root.left = null;
			root.right = null;
			return newNode;
		}
	}

}
