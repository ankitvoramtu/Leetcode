package problems;

import utilities.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

	public void connect1(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode cur;
		while (root.left != null) {
			cur = root;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			root = root.left;
		}
	}

	public void connect(TreeLinkNode root) {
		connect(root, null);
	}

	public void connect(TreeLinkNode root, TreeLinkNode sibling) {
		if (root == null) {
			return;
		} else {
			root.next = sibling;
		}
		connect(root.left, root.right);
		if (sibling == null) {
			connect(root.right, null);
		} else {
			connect(root.right, sibling.left);
		}
	}
}
