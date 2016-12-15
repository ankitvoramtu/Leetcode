package problems;

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger a = new ReverseInteger();
		System.out.println(a.reverse(321));
		System.out.println(a.reverse(-321));
		System.out.println(a.reverse(1534236469));
		System.out.println(a.reverse(Integer.MIN_VALUE));

	}

	public int reverse(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		int num = Math.abs(x);
		int ret = 0;
		while (num != 0) {
			if (ret > (Integer.MAX_VALUE - num % 10) / 10) {
				return 0;
			}
			ret = ret * 10 + num % 10;
			num = num / 10;
		}
		return x > 0 ? ret : -ret;
	}
}
