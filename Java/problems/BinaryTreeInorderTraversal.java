package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utilities.TreeNode;

public class BinaryTreeInorderTraversal {
	/*
	 * Morris Traversal
	 * ����O(1)�ռ���б�������Ϊ������ջ��Ϊ�����ռ������渶�ڵ����Ϣ���ص����ڵ����ʵ��ӽڵ��ʱ��������»ص����ڵ� ����Ȼ������ָû�и��ڵ�ָ��
	 * ���������ʵ�ͱȽϺð죬һֱ�ұ����ĺ�����㼴�ɣ���Morris�����������������������������������ҪΪÿ���ڵ�������ָ��ָ����ǰ���ͺ�̽��
	 * ����������Ҷ�ӽڵ��е��ҿ�ָ��ָ����������µĺ�̽ڵ�Ϳ����ˡ� �㷨�����������£� 1.
	 * �����ǰ��������Ϊ�գ��������ǰ��㲢���䵱ǰ�ڵ㸳ֵΪ�Һ��ӡ� 2.
	 * �����ǰ�ڵ�����Ӳ�Ϊ�գ���Ѱ�ҵ�ǰ�ڵ�����������µ�ǰ���ڵ㣨Ҳ���ǵ�ǰ��������������Һ��ӣ�������������������� a)
	 * ���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㣨������ʹ���Ժ�������·��ظ���㣩��Ȼ�󽫵�ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ� b)
	 * ���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ�
	 * �������������Ѿ������꣬���Է��ʵ�ǰ�ڵ㡣�������Һ���������Ϊ�գ��ָ����Ľṹ���������ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ���Һ��ӡ�
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (cur != null) {
			if (cur.left == null) {
				ret.add(cur.val);
				cur = cur.right;
			} else {
				pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;
					ret.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return ret;
	}

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				ret.add(root.val);
				root = root.right;
			}
		}
		return ret;
	}

	public List<Integer> inorderTraversa2(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		helper(ret, root);
		return ret;
	}

	private void helper(List<Integer> ret, TreeNode root) {
		if (root == null) {
			return;
		}
		helper(ret, root.left);
		ret.add(root.val);
		helper(ret, root.right);
	}
}
