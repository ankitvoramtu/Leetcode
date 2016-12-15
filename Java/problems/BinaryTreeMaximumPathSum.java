package problems;

import java.util.ArrayList;

import utilities.TreeNode;

public class BinaryTreeMaximumPathSum {
	/*
	 * �������������·���͵���Ŀ��������ƽ����ͬ���������·���������ԴӸ���ĳһ����㣬����·�����Դ�������ĳһ����㣬Ȼ�󵽴��������Ľ�㣬
	 * ������Ŀ����˵�Ŀ�����ʼ���ս����κν��
	 * ����������û�б���������ͼ�����Ǳ���������ͼ��Ѱ��·������Ϊ���·��������ԣ�������Ҫ�Եݹ鷵��ֵ����һЩ����
	 * ��������ͨ���ķ���Ҫ��Ľ��������������ķ���ֵ����Ϊ���Լ�Ϊ����һ���Ӹ����ӽ����·��������·���Ͳ��ǵ�������ͼ�ˣ��������������ߣ���
	 * �������ֵ��Ϊ���ṩ�����ĸ�������������·����
	 * �������������·����Ҳ���ǿ��Դ��������֣���ֻ�����Ȼ����¼��ɡ�����һ����һ�����������·��������������������ֵ
	 * ���������0�Ļ����������������ķ���ֵ
	 * ���������0�Ļ������ټ����Լ���ֵ��������ֵ�����Լ���ֵ��������������ֵ������������ֵ����0��ע�������ǡ�����
	 * ���������ǡ����ϡ�����Ϊ����ֵֻȡһ֧��·����
	 * �����ڹ�������õ�ǰ�·��ʱ�Ƚ�һ���ǲ���Ŀǰ��ģ����������¡��㷨�ı��ʻ���һ�����ı��������Ը��Ӷ���O
	 * (n)�����ռ�����Ȼ��ջ��СO(logn)���������£�
	 */
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(Integer.MIN_VALUE);
		helper(root, ret);
		return ret.get(0);
	}

	private int helper(TreeNode root, ArrayList<Integer> ret) {
		if (root == null)
			return 0;
		int left = helper(root.left, ret);
		int right = helper(root.right, ret);
		int cur = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		if (cur > ret.get(0)) {
			ret.set(0, cur);
		}
		return root.val + Math.max(left, Math.max(right, 0));
	}
}
