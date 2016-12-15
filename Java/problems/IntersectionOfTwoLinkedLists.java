package problems;

import utilities.ListNode;

public class IntersectionOfTwoLinkedLists {
	/*
	 * �������磬������Linked List Cycle II���⣬����Ҳ�����Ƶ�˫ָ�����������������ߣ�
	 * 
	 * 1. ����ж��������Ƿ��ཻ��
	 * �������ཻ�����Ǳ�Ȼ�й�ͬ��β�ڵ㡣���Ա������������ҵ����Ե�β�ڵ㣬���tailA!=tailB��һ�����ཻ����֮���ཻ��
	 * 
	 * 2. ����ж��������ཻ����ʼ�ڵ㣿
	 * �ڵ�1���ж��ཻʱ����˳������������ĳ���lenA��lenB���ó��������head����abs(lenA-lenB
	 * )����Ȼ��Ͷ������headһ���ߣ�ֱ��������������ΪҪ�ҵĽڵ㡣
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
