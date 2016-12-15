package problems;

import utilities.ListNode;

public class IntersectionOfTwoLinkedLists {
	/*
	 * 找链表交界，很类似Linked List Cycle II那题，方法也是类似的双指针相遇法。分两步走：
	 * 
	 * 1. 如何判断两链表是否相交？
	 * 两链表相交则他们必然有共同的尾节点。所以遍历两两链表，找到各自的尾节点，如果tailA!=tailB则一定不相交，反之则相交。
	 * 
	 * 2. 如何判断两链表相交的起始节点？
	 * 在第1步判断相交时可以顺带计算两链表的长度lenA和lenB。让长的链表的head先走abs(lenA-lenB
	 * )步，然后和短链表的head一起走，直到两者相遇，即为要找的节点。
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lenA = getLen(headA);
		int lenB = getLen(headB);

		if (lenA > lenB) {
			while (lenA > lenB) {
				headA = headA.next;
				lenA--;
			}
		} else {
			while (lenA < lenB) {
				headB = headB.next;
				lenB--;
			}
		}

		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public int getLen(ListNode node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != null && pB != null) {
			pA = pA.next;
			pB = pB.next;
		}
		if (pA == null) {
			pA = headB;
		} else {
			pB = headA;
		}
		while (pA != null && pB != null) {
			pA = pA.next;
			pB = pB.next;
		}
		if (pA == null) {
			pA = headB;
		} else {
			pB = headA;
		}
		while (pA != null && pB != null) {
			if (pA == pB) {
				return pA;
			}
			pA = pA.next;
			pB = pB.next;
		}
		return null;
	}

}
