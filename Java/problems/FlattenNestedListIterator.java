package problems;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import utilities.NestedInteger;

public class FlattenNestedListIterator implements Iterator<Integer> {

	Deque<NestedInteger> s;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		s = new LinkedList<NestedInteger>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			s.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return s.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!s.isEmpty()) {
			NestedInteger ni = s.peek();
			if (ni.isInteger()) {
				return true;
			} else {
				List<NestedInteger> list = s.pop().getList();
				for (int i = list.size() - 1; i >= 0; i--) {
					s.push(list.get(i));
				}
			}
		}
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
