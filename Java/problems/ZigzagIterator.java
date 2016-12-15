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
		// 如果没有下一个则返回0
		if (!hasNext()) {
			return 0;
		}
		turns++;
		// 如果是第奇数个，且第一个列表也有下一个元素时，返回第一个列表的下一个
		// 如果第二个列表已经没有，返回第一个列表的下一个
		if ((turns % 2 == 1 && it1.hasNext()) || (!it2.hasNext())) {
			return it1.next();
			// 如果是第偶数个，且第二个列表也有下一个元素时，返回第二个列表的下一个
			// 如果第一个列表已经没有，返回第二个列表的下一个
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
		// 将非空迭代器加入列表
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
		// 算出本次使用的迭代器的下标
		int pos = turns % itlist.size();
		Iterator<Integer> curr = itlist.get(pos);
		res = curr.next();
		// 如果这个迭代器用完，就将其从列表中移出
		if (!curr.hasNext()) {
			itlist.remove(turns % itlist.size());
			// turns变量更新为上一个下标
			turns = pos - 1;
		}
		turns++;
		return res;
	}

	public boolean hasNext() {
		return itlist.size() > 0;
	}

}
