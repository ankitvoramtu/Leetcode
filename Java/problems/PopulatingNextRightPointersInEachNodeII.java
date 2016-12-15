package problems;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
	public void connect1(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.offer(root);
		int preNum = 1;
		int curNum = 0;
		while (!q.isEmpty()) {
			TreeLinkNode node = q.poll();
			preNum--;
			if (node.left != null) {
				q.offer(node.left);
				curNum++;
			}
			if (node.right != null) {
				q.offer(node.right);
				curNum++;
			}
			if (preNum == 0) {
				node.next = null;
				preNum = curNum;
				curNum = 0;
			} else {
				node.next = q.peek();
			}
		}

	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode head = null; // head of the next level
		TreeLinkNode prev = null; // the leading node on the next level
		TreeLinkNode cur = root; // current node of current level
		while (cur != null) {
			while (cur != null) { // iterate on the current level
				// left child
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				// right child
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				// move to next node
				cur = cur.next;
			}

			// move to next level
			cur = head;
			head = null;
			prev = null;
		}
	}
}
