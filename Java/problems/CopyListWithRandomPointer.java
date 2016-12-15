package problems;

import java.util.HashMap;
import java.util.Map;

import utilities.RandomListNode;

public class CopyListWithRandomPointer {
	/*
	 * ����˼·�������ģ��������������ɨ�裬��һ��ɨ���ÿ�������и��ƣ�Ȼ��Ѹ��Ƴ������½ڵ����ԭ����next��Ҳ������������һ���ظ����������¾ɸ���
	 * ���ڶ���ɨ�������ǰѾɽ������ָ�븳���½ڵ�����ָ�룬��Ϊ�½�㶼���ھɽ�����һ�������Ը�ֵ�Ƚϼ򵥣�����node.next.random
	 * =
	 * node.random.next������node.next�����½�㣬��Ϊ��һ��ɨ�����Ǿ��ǰ��½����ھɽ����档�������ǰѽ������ָ�붼�Ӻ���
	 * ��
	 * ���һ��ɨ�����ǰ���������������һ����ԭԭ�������ڶ�����������Ҫ��ĸ���������Ϊ���������Ǿ��¸��棬ֻҪ��ÿ���������ֱ���������������зָ��
	 * ����������ܹ�������������ɨ�裬����ʱ�临�Ӷ���O(n)�������ﲢ����Ҫ����ռ䣬���Կռ临�Ӷ���O(1)����������ķ������������һ������ɨ�裬
	 * ���ǲ���Ҫ����ռ䣬���ǱȽ�ֵ�ġ�
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}
		RandomListNode node = head;
		while (node != null) {
			RandomListNode newNode = new RandomListNode(node.label);
			newNode.next = node.next;
			node.next = newNode;
			node = newNode.next;
		}
		node = head;
		while (node != null) {
			if (node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		RandomListNode newHead = head.next;
		node = head;
		while (node != null) {
			RandomListNode newNode = node.next;
			node.next = newNode.next;
			if (newNode.next != null)
				newNode.next = newNode.next.next;
			node = node.next;
		}
		return newHead;

	}

	public RandomListNode copyRandomList1(RandomListNode head) {
		if (head == null) {
			return head;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode pre = newHead;
		RandomListNode node = head.next;
		while (node != null) {
			RandomListNode newNode = new RandomListNode(node.label);
			map.put(node, newNode);
			pre.next = newNode;
			pre = newNode;
			node = node.next;
		}
		node = head;
		RandomListNode copyNode = newHead;
		while (node != null) {
			copyNode.random = map.get(node.random);
			copyNode = copyNode.next;
			node = node.next;
		}
		return newHead;
	}
}
