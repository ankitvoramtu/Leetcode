package problems;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n < 1) {
			return 0;
		}
		int[] ret = new int[n];
		ret[0] = 1;
		int[] idx = new int[primes.length];
		for (int i = 1; i < n; i++) {
			ret[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				ret[i] = Math.min(ret[i], primes[j] * ret[idx[j]]);
			}
			for (int j = 0; j < primes.length; j++) {
				if (ret[i] == ret[idx[j]] * primes[j]) {
					idx[j]++;
				}
			}
		}
		return ret[n - 1];
	}

}
