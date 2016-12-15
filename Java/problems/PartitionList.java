package problems;

import utilities.ListNode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head = head.next;
		}
		p1.next = l2.next;
		p2.next = null;
		return l1.next;
	}

	public ListNode partition2(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode prev = ret;
		ListNode cur = ret;

		while (cur.next != null) {
			if (cur.next.val < x) {
				if (prev == cur) {
					prev = prev.next;
					cur = cur.next;
				} else {
					ListNode tmp = cur.next.next;
					cur.next.next = prev.next;
					prev.next = cur.next;
					cur.next = tmp;
					prev = prev.next;
				}
			} else {
				cur = cur.next;
			}

		}
		return ret.next;
	}
}
