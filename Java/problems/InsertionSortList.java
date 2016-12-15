package problems;

import utilities.ListNode;

public class InsertionSortList {
	public static void main(String[] args) {
		InsertionSortList a = new InsertionSortList();
		ListNode node = new ListNode(4);
		node.next = new ListNode(3);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(1);
		a.insertionSortList(node);
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			pre = helper;
			while (pre.next != null && pre.next.val <= cur.val) {
				pre = pre.next;
			}
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return helper.next;
	}
}
