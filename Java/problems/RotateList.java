package problems;

import utilities.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		int len = 1;
		while (cur.next != null) {
			len++;
			cur = cur.next;
		}
		cur.next = head;
		k = len - k % len;
		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}
		head = cur.next;
		cur.next = null;
		return head;
	}
}
