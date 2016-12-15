package problems;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses a = new ValidParentheses();
		System.out.println(a.isValid("()[]{}"));
		System.out.println(a.isValid("()[]{}"));

	}

	public boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		int len = s.length();
		Stack<Character> stack = new Stack<Character>();
		String left = "([{";
		String right = ")]}";
		for (int i = 0; i < len; i++) {
			if (left.indexOf(s.charAt(i)) != -1) {
				stack.push(s.charAt(i));
			} else if (stack.empty()
					|| stack.pop() != left.charAt(right.indexOf(s.charAt(i)))) {
				return false;
			}
		}
		return stack.empty();
	}
}
