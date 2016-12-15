package problems;

import utilities.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode cur = head;
		for (int i = 0; i < n; i++) {
			if (cur != null) {
				cur = cur.next;
			}
		}
		ListNode prev = ret;
		while (cur != null) {
			prev = prev.next;
			cur = cur.next;
		}
		prev.next = prev.next.next;
		return ret.next;
	}
}
