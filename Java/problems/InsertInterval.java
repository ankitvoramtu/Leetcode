package problems;

import java.util.ArrayList;
import java.util.List;

import utilities.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			ret.add(newInterval);
			return ret;
		}
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			ret.add(intervals.get(i));
			i++;
		}
		if (i == intervals.size()) {
			ret.add(newInterval);
			return ret;
		}
		newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
		ret.add(newInterval);
		while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			i++;
		}
		while (i < intervals.size()) {
			ret.add(intervals.get(i));
			i++;
		}
		return ret;
	}
}
