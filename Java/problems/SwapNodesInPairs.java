package problems;

import utilities.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode ret = prev;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
        }
		return ret.next;
	}
}
