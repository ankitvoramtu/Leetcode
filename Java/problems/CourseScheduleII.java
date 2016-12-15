package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	public static void main(String[] args) {
		CourseScheduleII a = new CourseScheduleII();
		int[][] arr = new int[1][2];
		arr[0][0] = 1;
		arr[0][1] = 0;

		a.findOrder(2, arr);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] pCount = new int[numCourses];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int pre = prerequisites[i][1];
			int ready = prerequisites[i][0];
			list.get(pre).add(ready);
			pCount[ready]++;
		}
		int count = 0;
		int[] ret = new int[numCourses];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCount[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int val = q.poll();
			ret[count++] = val;
			for (int i = 0; i < list.get(val).size(); i++) {
				if (--pCount[list.get(val).get(i)] == 0) {
					q.offer(list.get(val).get(i));
				}
			}
		}
		if (count == numCourses) {
			return ret;
		} else {
			return new int[0];
		}
	}
}
