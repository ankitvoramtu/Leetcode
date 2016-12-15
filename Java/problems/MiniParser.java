package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MiniParser {
	class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger() {
		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
		}

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger() {
			return false;
		}

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return null;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
		}

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni) {
		}

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return null;
		}
	}

	public NestedInteger deserialize(String s) {
		if (!s.startsWith("[")) {
			return new NestedInteger(Integer.valueOf(s));
		}
		Deque<NestedInteger> stack = new LinkedList<NestedInteger>();
		NestedInteger ret = new NestedInteger();
		stack.push(ret);
		int start = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				NestedInteger ni = new NestedInteger();
				stack.peek().add(ni);
				stack.push(ni);
				start = i + 1;
			} else if (c == ',' || c == ']') {
				if (i > start) {
					Integer val = Integer.valueOf(s.substring(start, i));
					stack.peek().add(new NestedInteger(val));
				}
				start = i + 1;
				if (c == ']') {
					stack.pop();
				}
			}
		}
		return ret;
	}

}
