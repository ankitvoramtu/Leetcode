package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utilities.TreeNode;

public class BinaryTreePostorderTraversal {

	/*
	 * 区别是最下面在弹栈的时候需要分情况一下：
	 * 1）如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），那么就把当前结点移到右结点继续循环；
	 * 2）如果栈顶元素右结点是空或者已经访问过，那么说明栈顶元素的左右子树都访问完毕，应该访问自己继续回溯了。
	 */
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode pre = null;
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				TreeNode peekNode = s.peek();
				if (peekNode.right != null && pre != peekNode.right) {
					root = peekNode.right;
				} else {
					s.pop();
					ret.add(peekNode.val);
					pre = peekNode;
				}
			}
		}
		return ret;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root == null) {
			return ret;
		}
		s.push(root);
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			if (!s.isEmpty() && node == s.peek()) {
				if (node.right != null) {
					s.push(node.right);
					s.push(node.right);
				}
				if (node.left != null) {
					s.push(node.left);
					s.push(node.left);
				}
			} else {
				ret.add(node.val);
			}
		}
		return ret;

	}

	public List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		postorderTraversalRecursive(root, ret);
		return ret;
	}

	private void postorderTraversalRecursive(TreeNode root, List<Integer> ret) {
		if (root == null) {
			return;
		}
		postorderTraversalRecursive(root.left, ret);
		postorderTraversalRecursive(root.right, ret);
		ret.add(root.val);
	}

}
