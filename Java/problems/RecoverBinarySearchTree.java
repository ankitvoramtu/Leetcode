package problems;

import java.util.ArrayList;
import java.util.List;

import utilities.TreeNode;

public class RecoverBinarySearchTree {

	TreeNode prev = null;

	public void recoverTree2(TreeNode root) {
		if (root == null) {
			return;
		}
		List<TreeNode> ret = new ArrayList<TreeNode>();
		helper2(root, ret);
		if (ret.size() > 0) {
			int tmp = ret.get(0).val;
			ret.get(0).val = ret.get(1).val;
			ret.get(1).val = tmp;
		}
	}

	public void helper2(TreeNode root, List<TreeNode> ret) {
		if (root == null) {
			return;
		}
		helper2(root.left, ret);
		if (prev != null && prev.val > root.val) {
			if (ret.size() == 0) {
				ret.add(prev);
				ret.add(root);
			} else {
				ret.set(1, root);
			}
		}
		prev = root;
		helper2(root.right, ret);
	}

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		List<TreeNode> list = new ArrayList<TreeNode>();
		List<TreeNode> ret = new ArrayList<TreeNode>();
		helper(root, list, ret);
		if (ret.size() > 0) {
			int temp = ret.get(0).val;
			ret.get(0).val = ret.get(1).val;
			ret.get(1).val = temp;
		}
	}

	private void helper(TreeNode root, List<TreeNode> list, List<TreeNode> ret) {
		if (root == null) {
			return;
		}
		helper(root.left, list, ret);
		list.add(root);
		if (list.size() != 1 && list.get(list.size() - 2).val >= root.val) {
			if (ret.size() == 0) {
				ret.add(list.get(list.size() - 2));
				ret.add(root);
			} else {
				ret.set(1, root);
				return;
			}
		}
		helper(root.right, list, ret);
	}
}
