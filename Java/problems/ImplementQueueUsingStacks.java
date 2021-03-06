package problems;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks {
	Deque<Integer> s1 = new LinkedList<Integer>();
	Deque<Integer> s2 = new LinkedList<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		s1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		s2.pop();
	}

	// Get the front element.
	public int peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}

}
