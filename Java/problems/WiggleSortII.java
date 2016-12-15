package problems;

import java.util.Arrays;

public class WiggleSortII {
	public static void main(String[] args) {
		WiggleSortII a = new WiggleSortII();
		int[] nums = new int[] { 1, 5, 1, 1, 6, 4 };
		a.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void wiggleSort(int[] nums) {
		int mid = findKthLargest(nums, nums.length / 2 + 1);
		int n = nums.length;
		int left = 0, i = 0, right = n - 1;

		while (i <= right) {
			if (nums[newIndex(i, n)] > mid) {
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			} else if (nums[newIndex(i, n)] < mid) {
				swap(nums, newIndex(right--, n), newIndex(i, n));
			} else {
				i++;
			}
		}

	}

	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	public int findKthLargest(int[] nums, int k) {
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

	public void swap(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
