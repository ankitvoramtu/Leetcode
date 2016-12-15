package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (root == null) {
			return ret;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int curNum = 0;
		int preNum = 1;

		List<Integer> list = new LinkedList<Integer>();
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			preNum--;
			list.add(cur.val);
			if (cur.left != null) {
				q.offer(cur.left);
				curNum++;
			}
			if (cur.right != null) {
				q.offer(cur.right);
				curNum++;
			}
			if (preNum == 0) {
				preNum = curNum;
				curNum = 0;
				ret.add(list);
				list = new LinkedList<Integer>();
			}
		}
		return ret;
	}

	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		helper(ret, root, 0);
		return ret;
	}

	private void helper(List<List<Integer>> ret, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level >= ret.size()) {
			ret.add(new ArrayList<Integer>());
		}
		ret.get(level).add(root.val);
		helper(ret, root.left, level + 1);
		helper(ret, root.right, level + 1);
	}
}
