package problems;

import utilities.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode ret = new ListNode(0);
		ListNode cur = ret;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + carry;
			carry = val / 10;
			cur.next = new ListNode(val % 10);
			l1 = l1.next;
			l2 = l2.next;
			cur = cur.next;
		}
		while (l1 != null) {
			int val = l1.val + carry;
			carry = val / 10;
			cur.next = new ListNode(val % 10);
			l1 = l1.next;
			cur = cur.next;
		}
		while (l2 != null) {
			int val = l2.val + carry;
			carry = val / 10;
			cur.next = new ListNode(val % 10);
			l2 = l2.next;
			cur = cur.next;
		}
		if (carry != 0) {
			cur.next = new ListNode(carry);
		}
		return ret.next;
	}
}
