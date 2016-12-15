package problems;

import utilities.ListNode;

public class ReorderList {
	/*
	 * 这是一道比较综合的链表操作的题目，要按照题目要求给链表重新连接成要求的结果。其实理清思路也比较简单，分三步完成：（1）将链表切成两半，也就是找到中点
	 * ，然后截成两条链表；（2）将后面一条链表进行reverse操作，就是反转过来；（3）将两条链表按顺序依次merge起来。
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		ListNode head1 = head;
		ListNode head2 = walker.next;
		walker.next = null;
		head2 = reverse(head2);
		while (head1 != null && head2 != null) {
			ListNode next = head2.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			head2 = next;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public ListNode recursive_reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		return recursive_reverse(head, head.next);
	}

	private ListNode recursive_reverse(ListNode current, ListNode next) {
		if (next == null)
			return current;
		ListNode newHead = recursive_reverse(current.next, next.next);
		next.next = current;
		current.next = null;
		return newHead;
	}
}
