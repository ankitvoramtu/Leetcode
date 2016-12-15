package problems;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeNode;

public class MinimumDepthOfBinaryTree {
	/*
	 * �������������Ŀ����ʵ��Maximum Depth of Binary
	 * Tree�ǳ����ƣ�ֻ���������Ϊ���ж���С��ȣ����Ա�������һ��Ҷ�ӵ��жϣ�
	 * ��Ϊ���һ���ڵ����ֻ�����������������������ǲ���ȡ������������С����Ϊ���
	 * ����Ϊ��������0������ֻ����Ҷ�ӽڵ�����ж���ȣ������������ȵ�ʱ����Ϊһ����ȡ����Ǹ������Բ�����������⣩
	 */
	public int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int curNum = 0;
		int preNum = 1;
		int level = 0;

		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			preNum--;
			if (cur.left == null && cur.right == null) {
				return level + 1;
			}
			if (cur.left != null) {
				q.offer(cur.left);
				curNum++;
			}
			if (cur.right != null) {
				q.offer(cur.right);
				curNum++;
			}
			if (preNum == 0) {
				level++;
				preNum = curNum;
				curNum = 0;
			}
		}
		return level;
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}