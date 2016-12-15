package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	/*
	 * This problem can be converted to finding if a graph contains a cycle. The
	 * following solution use a breath-first search algorithm. You can read the
	 * comment to understand the solution.
	 */

	/*-
	 * Topological sorting
	L ¡û Empty list that will contain the sorted elements
	S ¡û Set of all nodes with no incoming edges
	while S is non-empty do
	    remove a node n from S
	    add n to tail of L
	    for each node m with an edge e from n to m do
	        remove edge e from the graph
	        if m has no other incoming edges then
	            insert m into S
	if graph has edges then
	    return error (graph has at least one cycle)
	else 
	    return L (a topologically sorted order)
	 */

	public static void main(String[] args) {
		CourseSchedule a = new CourseSchedule();
		// a.canFinish1(4, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 2 }
		// });
		a.canFinish1(2, new int[][] { { 1, 0 }, { 0, 1 } });
	}

	// Solution 1 - BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i->j
		int[] pCount = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int pre = prerequisites[i][1];
			int ready = prerequisites[i][0];
			if (matrix[pre][ready] == 0) { // duplicate case
				pCount[ready]++;
			}
			matrix[pre][ready] = 1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCount[i] == 0) {
				q.offer(i);
			}
		}
		int count = 0;
		while (!q.isEmpty()) {
			int val = q.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[val][i] != 0) {
					if (--pCount[i] == 0) {
						q.offer(i);
					}
				}
			}
		}
		return count == numCourses;
	}

	// DFS
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if (numCourses == 0 || len == 0) {
			return true;
		}

		// track visited courses
		int[] visit = new int[numCourses];

		// use the map to store what courses depend on a course
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int[] a : prerequisites) {
			if (map.containsKey(a[1])) {
				map.get(a[1]).add(a[0]);
			} else {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(a[0]);
				map.put(a[1], l);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (!canFinishDFS(map, visit, i))
				return false;
		}

		return true;
	}

	private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map,
			int[] visit, int i) {
		if (visit[i] == -1)
			return false;
		if (visit[i] == 1)
			return true;

		visit[i] = -1;
		if (map.containsKey(i)) {
			for (int j : map.get(i)) {
				if (!canFinishDFS(map, visit, j))
					return false;
			}
		}

		visit[i] = 1;

		return true;
	}

}
