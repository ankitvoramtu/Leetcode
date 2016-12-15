package problems;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

	int size;
	int ret;
	Deque<Integer> queue;

	public MovingAverage(int size) {
		this.size = size;
		ret = 0;
		queue = new LinkedList<Integer>();
	}

	public double next(int val) {
		queue.push(val);
		if (queue.size() > size) {
			ret -= queue.poll();
		}
		ret += val;
		return ret / queue.size();

	}
}
