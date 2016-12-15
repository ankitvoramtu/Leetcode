package problems;

public class FindPeakElement {
	/*
	 * 1）如果当前元素在3个连续数里为极大值，即为所求；
	 * 
	 * 2）如果3个连续数单调递增，则往右找；
	 * 
	 * 3）如果3个连续数单调递减，则往左找；
	 */
	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;
			if (nums[mid1] < nums[mid2]) {
				low = mid2;
			} else {
				high = mid1;
			}
		}
		return low;
	}

}
