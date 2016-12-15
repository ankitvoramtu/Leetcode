package problems;

import java.util.Arrays;

public class GraphValidTree {
	/*
	 * To test cyclic, we can make an array for each node (as array index), and
	 * the array will store the parent of the node (as array index). Every time
	 * we fetch a new pair of nodes, we trace the root node (the deepest parent
	 * node) of these two nodes, if it has the same root, then is will be a
	 * cycle; otherwise, we set the parent of second node to be the first node;
	 * 
	 * After we make sure there is node cycle in the graph, we simple test if
	 * there is enough edges to make this graph connected.
	 */
	public boolean validTree(int n, int[][] edges) {
		// initialize n isolated islands
		int[] nums = new int[n];
		Arrays.fill(nums, -1);

		// perform union find
		for (int i = 0; i < edges.length; i++) {
			int x = find(nums, edges[i][0]);
			int y = find(nums, edges[i][1]);

			// if two vertices happen to be in the same set
			// then there's a cycle
			if (x == y)
				return false;

			// union
			nums[x] = y;
		}

		return edges.length == n - 1;
	}

	int find(int nums[], int i) {
		if (nums[i] == -1)
			return i;
		return find(nums, nums[i]);
	}

}
