package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

	Iterator<Integer> it1;
	Iterator<Integer> it2;
	int turns;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.it1 = v1.iterator();
		this.it2 = v2.iterator();
		turns = 0;
	}

	public int next() {
		// ���û����һ���򷵻�0
		if (!hasNext()) {
			return 0;
		}
		turns++;
		// ����ǵ����������ҵ�һ���б�Ҳ����һ��Ԫ��ʱ�����ص�һ���б����һ��
		// ����ڶ����б��Ѿ�û�У����ص�һ���б����һ��
		if ((turns % 2 == 1 && it1.hasNext()) || (!it2.hasNext())) {
			return it1.next();
			// ����ǵ�ż�������ҵڶ����б�Ҳ����һ��Ԫ��ʱ�����صڶ����б����һ��
			// �����һ���б��Ѿ�û�У����صڶ����б����һ��
		} else if ((turns % 2 == 0 && it2.hasNext()) || (!it1.hasNext())) {
			return it2.next();
		}
		return 0;
	}

	public boolean hasNext() {
		return it1.hasNext() || it2.hasNext();
	}
}

class ZigzagIterator2 {

	List<Iterator<Integer>> itlist;
	int turns;

	public ZigzagIterator2(List<Iterator<Integer>> list) {
		this.itlist = new LinkedList<Iterator<Integer>>();
		// ���ǿյ����������б�
		for (Iterator<Integer> it : list) {
			if (it.hasNext()) {
				itlist.add(it);
			}
		}
		turns = 0;
	}

	public Integer next() {
		if (!hasNext()) {
			return 0;
		}
		Integer res = 0;
		// �������ʹ�õĵ��������±�
		int pos = turns % itlist.size();
		Iterator<Integer> curr = itlist.get(pos);
		res = curr.next();
		// ���������������꣬�ͽ�����б����Ƴ�
		if (!curr.hasNext()) {
			itlist.remove(turns % itlist.size());
			// turns��������Ϊ��һ���±�
			turns = pos - 1;
		}
		turns++;
		return res;
	}

	public boolean hasNext() {
		return itlist.size() > 0;
	}

}
