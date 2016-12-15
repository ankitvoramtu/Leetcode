package problems;

public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] flag = new boolean[n];
		for (int i = 2; i < n; i++) {
			flag[i] = true;
		}
		int ret = 0;
		for (int i = 2; i * i < n; i++) {
			if (flag[i]) {
				for (int j = i * i; j < n; j = j + i) {
					flag[j] = false;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (flag[i]) {
				ret++;
			}
		}
		return ret;
	}
}
