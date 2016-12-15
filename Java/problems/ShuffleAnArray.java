package problems;

public class ShuffleAnArray {

	int[] org;
	int[] ret;

	public ShuffleAnArray(int[] nums) {
		org = copy(nums);
		ret = nums;
	}

	private int[] copy(int[] nums) {
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = nums[i];
		}
		return arr;

	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		ret = copy(org);
		return ret;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		for (int i = org.length - 1; i >= 0; i--) {
			int index = randInt(i + 1);
			if (index != i) {
				int tmp = ret[i];
				ret[i] = ret[index];
				ret[index] = tmp;
			}
		}
		return ret;
	}

	private int randInt(int i) {
		return (int) (Math.random() * i);
	}

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
