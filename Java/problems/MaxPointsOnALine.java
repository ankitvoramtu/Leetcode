package problems;

import java.util.HashMap;
import java.util.Map;

import utilities.Point;

public class MaxPointsOnALine {
	public static void main(String[] args) {
		MaxPointsOnALine a = new MaxPointsOnALine();
		int ret = a.maxPoints(new Point[] { new Point(2, 3), new Point(3, 3),
				new Point(-5, 3) });
		System.out.println(ret);
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int max = 1;
		double ratio = 0.0;
		for (int i = 0; i < points.length - 1; i++) {
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			int numofSame = 0;
			int localMax = 1;
			for (int j = i + 1; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					numofSame++;
					continue;
				} else if (points[j].x == points[i].x) {
					ratio = (double) Integer.MAX_VALUE;
					// this is very import, ratio may be 0.0 or -0.0
				} else if (points[j].y == points[i].y) {
					ratio = 0.0;
				} else {
					ratio = (double) (points[j].y - points[i].y)
							/ (double) (points[j].x - points[i].x);
				}

				if (map.containsKey(ratio)) {
					map.put(ratio, map.get(ratio) + 1);
				} else {
					map.put(ratio, 2);
				}
			}
			for (Integer value : map.values()) {
				localMax = Math.max(localMax, value);
			}
			localMax += numofSame;
			max = Math.max(max, localMax);
		}
		return max;
	}
}
