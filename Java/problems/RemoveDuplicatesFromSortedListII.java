package problems;

import utilities.ListNode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode prev = ret;
		ListNode cur = head;
		boolean isSame = false;
		while (cur.next != null) {
			if (cur.next.val == cur.val) {
				cur.next = cur.next.next;
				isSame = true;
			} else {
				if (isSame) {
					prev.next = cur.next;
					isSame = false;
				} else {
					prev = prev.next;
				}
				cur = cur.next;
			}
		}
		if (isSame) {
			prev.next = cur.next;
		}
		return ret.next;
	}
}
