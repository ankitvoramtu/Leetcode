package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utilities.TreeNode;

public class BinaryTreePostorderTraversal {

	/*
	 * �������������ڵ�ջ��ʱ����Ҫ�����һ�£�
	 * 1�������ǰջ��Ԫ�ص��ҽ����ڲ��һ�û���ʹ���Ҳ�����ҽ�㲻������һ�����ʽ�㣩����ô�Ͱѵ�ǰ����Ƶ��ҽ�����ѭ����
	 * 2�����ջ��Ԫ���ҽ���ǿջ����Ѿ����ʹ�����ô˵��ջ��Ԫ�ص�����������������ϣ�Ӧ�÷����Լ����������ˡ�
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
