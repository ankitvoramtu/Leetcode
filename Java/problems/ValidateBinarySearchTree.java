package problems;

import java.util.ArrayList;
import java.util.List;

import utilities.TreeNode;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		ValidateBinarySearchTree a = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		System.out.println(a.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		return helper(root, ret);
	}

	private boolean helper(TreeNode root, List<Integer> ret) {
		if (root == null) {
			return true;
		}
		boolean left = helper(root.left, ret);
		ret.add(root.val);
		if (ret.size() != 1 && ret.get(ret.size() - 2) >= root.val) {
			return false;
		}
		return left && helper(root.right, ret);
	}

	public boolean isValidBST1(TreeNode root) {
		return helper1(root, null, null);
	}

	private boolean helper1(TreeNode root, Integer minValue, Integer maxValue) {
		if (root == null) {
			return true;
		}
		if ((minValue != null && root.val <= minValue)
				|| (maxValue != null && root.val >= maxValue)) {
			return false;
		}
		return helper1(root.left, minValue, root.val)
				&& helper1(root.right, root.val, maxValue);
	}
}
