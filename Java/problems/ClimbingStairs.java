package problems;

public class ClimbingStairs {
	public static void main(String[] args) {
		ClimbingStairs a = new ClimbingStairs();
		System.out.println(a.climbStairs(44));
		System.out.println(a.climbStairs1(44));
	}

	public int climbStairs(int n) {
		if (n < 1) {
			return 0;
		}
		if (n < 3) {
			return n;
		}
		int first = 1;
		int second = 2;
		for (int i = 3; i <= n; i++) {
			int tmp = first + second;
			first = second;
			second = tmp;
		}
		return second;
	}

	public int climbStairs1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		} else {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}
}
