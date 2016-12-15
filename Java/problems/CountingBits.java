package problems;

import java.util.Arrays;

public class CountingBits {
	public static void main(String[] args) {
		CountingBits a = new CountingBits();
		System.out.println(Arrays.toString(a.countBits2(12)));
	}

	public int[] countBits2(int num) {
		int[] ret = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			ret[i] = ret[i >>> 1] + (i & 1);
		}
		return ret;

	}

	public int[] countBits(int num) {
		int[] ret = new int[num + 1];
		int n = 1;
		int i = 1;
		while (i <= num) {
			for (int j = 0; i <= num && j < n; j++) {
				ret[i] = ret[i - n] + 1;
				i++;
			}
			n *= 2;

		}
		return ret;
	}
}
