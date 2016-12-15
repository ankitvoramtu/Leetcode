package problems;

import utilities.ListNode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) { // odd number
			slow = slow.next;
		}
		ListNode reverse = null;
		while (slow != null) {
			ListNode n = slow;
			slow = slow.next;
			n.next = reverse;
			reverse = n;
		}

		while (reverse != null) {
			if (reverse.val != head.val) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		return true;

	}

}
