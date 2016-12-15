package problems;

import java.util.HashMap;

import utilities.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(postorder, 0, postorder.length - 1, inorder, 0,
				inorder.length - 1, map);
	}

	private TreeNode helper(int[] postorder, int postL, int postR,
			int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
		if (postL > postR || inL > inR)
			return null;
		TreeNode root = new TreeNode(postorder[postR]);
		int index = map.get(root.val);
		root.left = helper(postorder, postL, index - inL + postL - 1, inorder,
				inL, index - 1, map);
		root.right = helper(postorder, postL + index - inL, postR - 1, inorder,
				index + 1, inR, map);
		return root;
	}
}
