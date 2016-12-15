package problems;

public class ReverseString {

	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public String reverseString1(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			char tmp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = tmp;
		}
		return new String(c);
	}

}
