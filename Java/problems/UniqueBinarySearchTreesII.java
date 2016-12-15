package problems;

import java.util.LinkedList;
import java.util.List;

import utilities.TreeNode;

public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		UniqueBinarySearchTreesII a = new UniqueBinarySearchTreesII();
		System.out.println(a.generateTrees(3));
	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ret = new LinkedList<TreeNode>();
		if (n <= 0) {
			return ret;
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int l, int r) {
		List<TreeNode> ret = new LinkedList<TreeNode>();
		if (l > r) {
			ret.add(null);
			return ret;
		}
		for (int i = l; i <= r; i++) {
			List<TreeNode> left = helper(l, i - 1);
			List<TreeNode> right = helper(i + 1, r);
			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(j);
					root.right = right.get(k);
					ret.add(root);
				}
			}
		}
		return ret;
	}
}
