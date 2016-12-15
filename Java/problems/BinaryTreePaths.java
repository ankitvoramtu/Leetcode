package problems;

import java.util.LinkedList;
import java.util.List;

import utilities.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ret = new LinkedList<String>();
		if (root == null) {
			return ret;
		}
		if (root.left == null && root.right == null) {
			ret.add(Integer.toString(root.val));
			return ret;
		}

		List<String> l = binaryTreePaths(root.left);
		for (int i = 0; i < l.size(); i++) {
			String str = l.get(i);
			str = root.val + "->" + str;
			ret.add(str);
		}
		List<String> r = binaryTreePaths(root.right);
		for (int i = 0; i < r.size(); i++) {
			String str = r.get(i);
			str = root.val + "->" + str;
			ret.add(str);
		}
		return ret;
	}
}
