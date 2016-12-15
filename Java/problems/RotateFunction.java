package problems;

public class RotateFunction {

	public int maxRotateFunction(int[] A) {
		int n = A.length;
		int val = 0;
		int sum = 0;
		int ret;
		for (int i = 0; i < n; i++) {
			sum += A[i];
			val += i * A[i];
		}
		ret = val;
		for (int i = 1; i < n; i++) {
			val = val + sum - n * A[n - i];
			ret = Math.max(ret, val);
		}
		return ret;
	}

}
