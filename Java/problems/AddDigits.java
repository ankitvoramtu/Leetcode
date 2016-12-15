package problems;

public class AddDigits {
	public static void main(String[] args) {
		System.out.println(-1 % 9);
	}

	public int addDigits(int num) {
		while (num >= 10) {
			int ret = 0;
			while (num != 0) {
				ret += num % 10;
				num /= 10;
			}
			num = ret;
		}
		return num;
	}

	public int addDigits2(int num) {
		return 1 + ((num - 1) % 9);
	}

	public int addDigits1(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 9 == 0) {
			return 9;
		} else {
			return num % 9;
		}
	}
}
