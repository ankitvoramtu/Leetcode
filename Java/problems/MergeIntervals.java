package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utilities.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<Interval>();
		if (intervals == null || intervals.size() < 2) {
			return intervals;
		}
		Comparator<Interval> comp = new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) {
					return i1.end - i2.end;
				}
				return i1.start - i2.start;
			}
		};
		Collections.sort(intervals, comp);
		ret.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			int end = ret.get(ret.size() - 1).end;
			int start = intervals.get(i).start;
			if (start <= end) {
				ret.get(ret.size() - 1).end = Math.max(end,
						intervals.get(i).end);
			} else {
				ret.add(intervals.get(i));
			}
		}
		return ret;
	}
}
