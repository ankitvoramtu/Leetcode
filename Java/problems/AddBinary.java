package problems;

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		StringBuilder ret = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		int num;
		while (i >= 0 && j >= 0) {
			num = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
			ret.append(num % 2);
			carry = num / 2;
			i--;
			j--;
		}
		while (i >= 0) {
			num = a.charAt(i) - '0' + carry;
			ret.append(num % 2);
			carry = num / 2;
			i--;
		}
		while (j >= 0) {
			num = b.charAt(j) - '0' + carry;
			ret.append(num % 2);
			carry = num / 2;
			j--;
		}
		if (carry > 0) {
			ret.append(carry);
		}
		return ret.reverse().toString();
	}
}
