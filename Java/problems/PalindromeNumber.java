package problems;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber a = new PalindromeNumber();
		System.out.println(a.isPalindrome(1001));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int d = 1;
		while (x / d >= 10) {
			d *= 10;
		}
		// this is important, can't write x >=10, e.g. 100021
		while (x > 0) {
			int right = x % 10;
			int left = x / d;
			if (left != right) {
				return false;
			}
			x = x % d / 10;
			d /= 100;
		}
		return true;
	}
}
