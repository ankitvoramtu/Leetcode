package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utilities.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		List<Integer> item = new ArrayList<Integer>();
		item.add(root.val);
		helper(root, sum - root.val, item, ret);
		return ret;
	}

	private void helper(TreeNode root, int sum, List<Integer> item,
			List<List<Integer>> ret) {
		if (root.left == null && root.right == null && sum == 0) {
			ret.add(new ArrayList<Integer>(item));
			return;
		}
		if (root.left != null) {
			item.add(root.left.val);
			helper(root.left, sum - root.left.val, item, ret);
			item.remove(item.size() - 1);
		}
		if (root.right != null) {
			item.add(root.right.val);
			helper(root.right, sum - root.right.val, item, ret);
			item.remove(item.size() - 1);
		}
	}

	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		helper2(ret, new LinkedList<Integer>(), root, sum);
		return ret;
	}

	public void helper2(List<List<Integer>> ret, List<Integer> cur,
			TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		cur.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			ret.add(new LinkedList<Integer>(cur));
		}
		helper2(ret, cur, root.left, sum - root.val);
		helper2(ret, cur, root.right, sum - root.val);
		cur.remove(cur.size() - 1);
	}

}
