package problems;

public class BasicCalculatorII {

	public static void main(String[] args) {
		BasicCalculatorII a = new BasicCalculatorII();
		int ret = a.calculate("1+1");
		System.out.println(ret);
	}

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ret = 0;
		int pre = 0;
		char sign = '+';
		int cur = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			} else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				cur = cur * 10 + (s.charAt(i) - '0');
			} else {
				if (sign == '+') {
					ret += pre;
					pre = cur;
				} else if (sign == '-') {
					ret += pre;
					pre = -cur;
				} else if (sign == '*') {
					pre *= cur;
				} else if (sign == '/') {
					pre /= cur;
				}
				sign = s.charAt(i);
				cur = 0;
			}
		}
		if (sign == '+') {
			ret += pre;
			pre = cur;
		} else if (sign == '-') {
			ret += pre;
			pre = -cur;
		} else if (sign == '*') {
			pre *= cur;
		} else if (sign == '/') {
			pre /= cur;
		}
		return ret + pre;
	}

}
