package problems;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		shuffle(nums);
		k = nums.length - k;
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int j = partition(nums, l, r);
			if (j == k) {
				break;
			} else if (j < k) {
				l = j + 1;
			} else {
				r = j - 1;
			}
		}
		return nums[k];
	}

	private int partition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int j = l - 1;
		for (int i = l; i < r; i++) {
			if (nums[i] <= pivot) {
				j++;
				swap(nums, i, j);
			}
		}
		swap(nums, j + 1, r);
		return j + 1;
	}

	public void shuffle(int[] nums) {
		Random rand = new Random();
		for (int i = nums.length - 1; i > 0; i--) {
			int j = rand.nextInt(nums.length);
			swap(nums, i, j);
		}
	}

	public void swap(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public int findKthLargest1(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			q.offer(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > q.peek()) {
				q.poll();
				q.add(nums[i]);
			}
		}
		return q.peek();
	}

}
