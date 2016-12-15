package problems;

import utilities.ListNode;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// get second node
		ListNode second = head.next;
		// set first's next to be null
		head.next = null;

		ListNode rest = reverseList(second);
		second.next = head;

		return rest;

	}

	public ListNode reverseList1(ListNode head) {
        ListNode ret = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = ret;
            ret = tmp;
        }
        return ret;
    }
}
