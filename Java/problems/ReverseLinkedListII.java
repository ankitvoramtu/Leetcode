package problems;

import utilities.ListNode;

public class ReverseLinkedListII {
	public static void main(String[] args) {
		ReverseLinkedListII a = new ReverseLinkedListII();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		a.reverseBetween2(head,	 2, 4);
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		System.out.println(head.next.next.next.val);
		System.out.println(head.next.next.next.next.val);
	}
	public ListNode reverseBetween2(ListNode head, int m, int n) {

		if (head == null) {
			return head;
		}
		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode prev = ret;
		ListNode cur = head;
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
			cur = cur.next;
		}
		ListNode last = cur;
		for (int i = 0; i < n - m; i++) {
			ListNode node = cur;
			prev.next = cur.next;
			cur = cur.next;
			cur.next = node;
		}
		last.next = cur.next;
		return ret.next;

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode ret = new ListNode(0);
		ListNode prev = ret;
		ret.next = head;
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}
		ListNode cur = prev.next;
		for (int i = 0; i < n - m; i++) {
			ListNode node = cur.next;
			cur.next = node.next;
			node.next = prev.next;
			prev.next = node;
		}
		return ret.next;
	}
}
