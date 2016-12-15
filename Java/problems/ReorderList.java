package problems;

import utilities.ListNode;

public class ReorderList {
	/*
	 * ����һ���Ƚ��ۺϵ������������Ŀ��Ҫ������ĿҪ��������������ӳ�Ҫ��Ľ������ʵ����˼·Ҳ�Ƚϼ򵥣���������ɣ���1���������г����룬Ҳ�����ҵ��е�
	 * ��Ȼ��س�����������2��������һ���������reverse���������Ƿ�ת��������3������������˳������merge������
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
