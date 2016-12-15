package problems;

import java.util.Random;
import utilities.ListNode;

public class LinkedListRandomNode {
	ListNode head;
	Random random;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public LinkedListRandomNode(ListNode head) {
		this.head = head;

	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode c = head;
		int r = c.val;
		for (int i = 1; c.next != null; i++) {
			c = c.next;
			if (randInt(0, i) == i) {
				r = c.val;
			}
		}

		return r;
	}

	private int randInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

}
