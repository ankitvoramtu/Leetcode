package problems;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new LinkedList<int[]>();
		if (nums1 == null || nums2 == null || nums1.length == 0
				|| nums2.length == 0 || k <= 0) {
			return ret;
		}
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(10,
				new Comparator<int[]>() {
					@Override
					public int compare(int[] a, int[] b) {
						return (a[0] + a[1] - b[0] - b[1]);
					}
				});

		for (int i = 0; i < nums1.length && i < k; i++) {
			q.offer(new int[] { nums1[i], nums2[0], 0 });
		}
		while (k-- > 0 && !q.isEmpty()) {
			int[] cur = q.poll();
			ret.add(new int[] { cur[0], cur[1] });
			if (cur[2] == nums2.length - 1) {
				continue;
			}
			q.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		return ret;
	}

	public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new LinkedList<int[]>();

		if (nums1 == null || nums2 == null || k <= 0) {
			return ret;
		}
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(10,
				new Comparator<int[]>() {
					@Override
					public int compare(int[] a, int[] b) {
						return -(a[0] + a[1] - b[0] - b[1]);
					}
				});
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (k > 0) {
					q.offer(new int[] { nums1[i], nums2[j] });
					k--;
				} else if (nums1[i] + nums2[j] < q.peek()[0] + q.peek()[1]) {
					q.poll();
					q.offer(new int[] { nums1[i], nums2[j] });
				} else {
					break;
				}
			}
		}
		while (!q.isEmpty()) {
			ret.add(q.poll());
		}
		return ret;
	}
}
