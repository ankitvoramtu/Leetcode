package problems;

import utilities.ListNode;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		OddEvenLinkedList a = new OddEvenLinkedList();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		ListNode ret = a.oddEvenList(l);
		System.out.println(ret);
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = new ListNode(0);
		ListNode l1 = odd;
		ListNode even = new ListNode(0);
		ListNode l2 = even;
		ListNode cur = head;
		int count = 1;
		while (cur != null) {
			if (count % 2 == 1) {
				odd.next = cur;
				odd = odd.next;
			} else {
				even.next = cur;
				even = even.next;
			}
			cur = cur.next;
			count++;
		}
		odd.next = l2.next;
		even.next = null;
		return l1.next;
	}

}
