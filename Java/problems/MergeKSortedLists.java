package problems;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import utilities.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists1(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		return helper(lists, 0, lists.size() - 1);
	}

	public ListNode helper(List<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			return merge(helper(lists, l, m), helper(lists, m + 1, r));
		}
		return lists.get(l);
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}
		return head.next;
	}

	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		Comparator<ListNode> comparator = new QueueComparator();
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(10,
				comparator);
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (queue.size() != 0) {
			ListNode top = queue.poll();
			cur.next = top;
			cur = cur.next;
			if (top.next != null) {
				queue.add(top.next);
			}
		}
		return head.next;
	}

	class QueueComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		}
	}

}
