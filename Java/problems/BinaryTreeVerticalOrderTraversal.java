package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import utilities.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> cols = new LinkedList<Integer>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			ret.add(map.get(i));
		}

		return ret;
	}

}
