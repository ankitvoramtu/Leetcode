package problems;

import java.util.Stack;

public class LongestValidParentheses {
	/**
	 * �������������������У��Ƚ������뵽��ջ������ݽṹ������˼·����ά��һ��ջ�����������žͽ�ջ���������������ջ��
	 * �����жϵ�ǰ�Ϸ������Ƿ�Ϊ�����
	 * ����������⿴��˼·�򵥣����������Ƚϵ���Ĳ��Լ���������˵����Ҫ�����������������ʱ����жϵ�ǰ�ĺϷ����еĳ��ȡ��ȽϽ�׳�ķ�ʽ���£� (1)
	 * �����ǰջΪ�գ���˵�����ϵ�ǰ������û�кϷ����У���Ҳ��֮ǰ�жϹ��ģ��� (2)
	 * ���򵯳�ջ��Ԫ�أ����������ջΪ�գ���˵����ǰ����ƥ�䣬���ǻ�ά��һ���Ϸ���ʼ�����start
	 * ���Ϸ����еĳ��ȼ�Ϊ��ǰԪ�ص�λ��-start+1���������ջ������Ԫ��
	 * ����ǰ�Ϸ����еĳ���Ϊ��ǰջ��Ԫ�ص�λ����һλ����ǰԪ�صľ��룬��Ϊջ��Ԫ�غ�������ŶԿ϶��ǺϷ��ģ����������ų���ջ�ˡ�
	 */

	public static void main(String[] args) {
		LongestValidParentheses a = new LongestValidParentheses();
		System.out.println(a.longestValidParentheses("(()"));

	}

	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		int ret = 0;
		int start = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.empty()) {
					start = i + 1;
				} else {
					stack.pop();
					if (stack.empty()) {
						ret = max(ret, i - start + 1);
					} else {
						ret = max(ret, i - stack.peek());
					}
				}
			}
		}
		return ret;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}
}
