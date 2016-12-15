package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import utilities.Interval;

public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] < ends[endsItr]) {
				rooms++;
			} else {
				endsItr++;
			}
		}
		return rooms;
	}

	public int minMeetingRooms1(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
		endTimes.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= endTimes.peek()) {
				endTimes.poll();
			}
			endTimes.offer(intervals[i].end);
		}
		return endTimes.size();
	}

}
