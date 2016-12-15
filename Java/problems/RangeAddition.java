package problems;

public class RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] ret = new int[length];
		for (int[] update : updates) {
			int value = update[2];
			int start = update[0];
			int end = update[1];

			ret[start] += value;

			if (end < length - 1)
				ret[end + 1] -= value;

		}

		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += ret[i];
			ret[i] = sum;
		}

		return ret;
	}

}
