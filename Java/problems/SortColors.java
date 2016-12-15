package problems;

public class SortColors {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int idx0 = 0;
		int idx1 = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				A[i] = 2;
				A[idx1++] = 1;
				A[idx0++] = 0;
			} else if (A[i] == 1) {
				A[i] = 2;
				A[idx1++] = 1;
			}
		}
	}

	public void sortColors1(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int[] count = new int[3];
		for (int i = 0; i < A.length; i++) {
			count[A[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		int[] ret = new int[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			ret[count[A[i]] - 1] = A[i];
			count[A[i]]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = ret[i];
		}
	}

	public void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int red = 0;
		int blue = nums.length - 1;
		int i = 0;
		while (i <= blue) {
			if (nums[i] == 0) {
				int tmp = nums[i];
				nums[i] = nums[red];
				nums[red++] = tmp;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				int tmp = nums[i];
				nums[i] = nums[blue];
				nums[blue--] = tmp;
			}
		}
	}

}
