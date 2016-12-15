package problems;

import java.util.LinkedList;
import java.util.Queue;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] ret = new int[n];
		ret[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < n; i++) {
			ret[i] = Math.min(Math.min(ret[p2] * 2, ret[p3] * 3), ret[p5] * 5);
			// Be careful about the cases such as 6, in which we need to forward
			// both pointers of 2 and 3.
			if (ret[i] == ret[p2] * 2) {
				p2++;
			}
			if (ret[i] == ret[p3] * 3) {
				p3++;
			}
			if (ret[i] == ret[p5] * 5) {
				p5++;
			}
		}
		return ret[n - 1];
	}

	public int nthUglyNumber1(int n) {
		long ret = 0;
		if (n == 1) {
			return 1;
		}
		Queue<Long> q2 = new LinkedList<Long>();
		Queue<Long> q3 = new LinkedList<Long>();
		Queue<Long> q5 = new LinkedList<Long>();
		q2.offer(2L);
		q3.offer(3L);
		q5.offer(5L);
		for (int i = 1; i < n; i++) {
			long v2 = q2.peek();
			long v3 = q3.peek();
			long v5 = q5.peek();
			if (v2 < v3 && v2 < v5) {
				ret = q2.poll();
				q2.offer(v2 * 2);
				q3.offer(v2 * 3);
				q5.offer(v2 * 5);
			} else if (v3 < v5) {
				ret = q3.poll();
				q3.offer(v3 * 3);
				q5.offer(v3 * 5);
			} else {
				ret = q5.poll();
				q5.offer(v5 * 5);
			}
		}
		return (int) ret;
	}

}
