package problems;

import java.util.Stack;

public class MinStack {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(int x) {
		if (min.isEmpty() || x <= min.peek()) {
			min.push(x);
		}
		s.push(x);
	}

	public void pop() {
		if (!s.isEmpty()) {
			int val = s.pop();
			if (val == min.peek()) {
				min.pop();
			}
		}
	}

	public int top() {
		if (!s.isEmpty()) {
			return s.peek();
		} else {
			return 0;
		}
	}

	public int getMin() {
		if (!min.isEmpty()) {
			return min.peek();
		} else {
			return 0;
		}
	}
}
