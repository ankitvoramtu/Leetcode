package problems;
public class CountNumbersWithUniqueDigits {

	public int countNumbersWithUniqueDigits(int n) {
		// f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2)
		// [The first factor is 9 because a number cannot start with 0].
		if (n == 0) {
			return 1;
		}
		int sum = 10;
		int val = 9;
		for (int i = 2; i <= 11 && i <= n; i++) {
			val = val * (9 - i + 2);
			sum += val;
		}
		return sum;

	}
}
