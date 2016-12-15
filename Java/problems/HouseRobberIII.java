package problems;

import java.util.HashMap;
import java.util.Map;

import utilities.TreeNode;

public class HouseRobberIII {
	public int rob2(TreeNode root) {
		return helper(root, new HashMap<TreeNode, Integer>());
	}

	private int helper(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}
		if (map.containsKey(root)) {
			return map.get(root);
		}

		int val = 0;

		if (root.left != null) {
			val += helper(root.left.left, map) + helper(root.left.right, map);
		}

		if (root.right != null) {
			val += helper(root.right.left, map) + helper(root.right.right, map);
		}

		val = Math.max(val + root.val,
				helper(root.left, map) + helper(root.right, map));
		map.put(root, val);

		return val;
	}

	public int rob(TreeNode root) {
		// ret[0] is root is not robbed
		// ret[1] is root is robbed
		int[] ret = robSub(root);
		return Math.max(ret[0], ret[1]);
	}

	private int[] robSub(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] left = robSub(root.left);
		int[] right = robSub(root.right);
		int[] ret = new int[2];

		ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		ret[1] = root.val + left[0] + right[0];

		return ret;
	}

}
