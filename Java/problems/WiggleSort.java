package problems;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 1 && (nums[i - 1] > nums[i])) {
				swap(nums, i);
			}
			if (i % 2 == 0 && (nums[i - 1] < nums[i])) {
				swap(nums, i);
			}
		}
	}

	void swap(int[] nums, int i) {
		int temp = nums[i];
		nums[i] = nums[i - 1];
		nums[i - 1] = temp;
	}

}
