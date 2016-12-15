package problems;

import utilities.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode p = helper;

		while (p.next != null) {
			if (p.next.val == val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return helper.next;
	}
}
