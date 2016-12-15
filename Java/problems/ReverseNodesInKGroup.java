package problems;

import utilities.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k <= 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		int count = 0;

		ListNode cur = head;
		while (cur != null) {
			count++;
			cur = cur.next;
			if (count == k) {
				prev = reverseNode(prev, cur);
				count = 0;
			}
		}
		return dummy.next;
	}

	/*
	 * the real list need to reverse is from (prev, end), both prev and end are
	 * exclusive
	 */
	public ListNode reverseNode(ListNode prev, ListNode end) {
		ListNode head = prev.next;
		ListNode cur = head.next;
		while (cur != end) {
			ListNode next = cur.next;
			cur.next = prev.next;
			prev.next = cur;
			cur = next;
		}
		head.next = end;
		return head;
	}

}
