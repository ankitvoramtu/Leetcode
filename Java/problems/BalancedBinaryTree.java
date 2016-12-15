package problems;

import utilities.TreeNode;

public class BalancedBinaryTree {
	/*
	 * ����������һ��������������ֵ����0��������������ʾ������ȣ���-1�������Ƚϴ����Ѿ���ƽ���ˣ�����Ѿ���ƽ�⣬��ݹ�һֱ����-1���ɣ�
	 * Ҳû�м����Ƚϵı�Ҫ��
	 * ����������÷��ص������Ϣ�������������ǲ���Υ��ƽ�����������Υ������-1�����򷵻�����������ȴ�ļ�һ��Ϊ�Լ�����ȼ��ɡ�
	 * �㷨��ʱ����һ�����ı���O (n)���ռ���ջ�߶�O(logn)��
	 */

	public boolean isBalanced1(TreeNode root) {
		return helper(root) >= 0;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (left < 0 || right < 0) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
