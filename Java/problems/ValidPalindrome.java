package problems;

public class ValidPalindrome {

	public boolean isPalindrome2(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			}
			while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			}
			if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s
					.charAt(r))) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (!isValid(s.charAt(l))) {
				l++;
				continue;
			}
			if (!isValid(s.charAt(r))) {
				r--;
				continue;
			}
			if (!isSame(s.charAt(l), s.charAt(r))) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	private boolean isValid(char c) {
		if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0'
				&& c <= '9') {
			return true;
		} else {
			return false;
		}
	}

	private boolean isSame(char c1, char c2) {
		if (c1 >= 'A' && c1 <= 'Z') {
			c1 = (char) (c1 - 'A' + 'a');
		}
		if (c2 >= 'A' && c2 <= 'Z') {
			c2 = (char) (c2 - 'A' + 'a');
		}
		return c1 == c2;
	}
}
