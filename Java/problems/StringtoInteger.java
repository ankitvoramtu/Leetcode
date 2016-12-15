package problems;

public class StringtoInteger {
	/**
	 * 这种题的考察重点并不在于问题本身，而是要注意corner
	 * case的处理，整数一般有两点，一个是正负符号问题，另一个是整数越界问题。思路比较简单，就是先去掉多余的空格字符
	 * ，然后读符号（注意正负号都有可能，也有可能没有符号
	 * ），接下来按顺序读数字，结束条件有三种情况：（1）异常字符出现（按照C语言的标准是把异常字符起的后面全部截去
	 * ，保留前面的部分作为结果）；（2）数字越界（返回最接近的整数）；（3）字符串结束。
	 */
	public static void main(String[] args) {
		StringtoInteger a = new StringtoInteger();
		System.out.println(a.atoi("-2147483648"));

	}

	public int atoi(String str) {
		int i = 0, n = str.length();
		while (i < n && Character.isWhitespace(str.charAt(i)))
			i++;
		int sign = 1;
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		int num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			if (sign == -1 && (Integer.MIN_VALUE + digit) / 10 > -num) {
				return Integer.MIN_VALUE;
			}
			if (sign == 1 && (Integer.MAX_VALUE - digit) / 10 < num) {
				return Integer.MAX_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;

	}

	public int atoi1(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		int i = 0;
		boolean isNeg = false;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			i++;
			if (str.charAt(0) == '-') {
				isNeg = true;
			}
		}
		int len = str.length();
		int ret = 0;
		while (i < len) {
			if (str.charAt(i) > '9' || str.charAt(i) < '0') {
				break;
			}
			int num = str.charAt(i) - '0';
			if (isNeg && (Integer.MIN_VALUE + num) / 10 > -ret) {
				return Integer.MIN_VALUE;
			}
			if (!isNeg && (Integer.MAX_VALUE - num) / 10 < ret) {
				ret = Integer.MAX_VALUE;
				break;
			}
			ret = ret * 10 + num;
			i++;
		}
		return isNeg ? -ret : ret;
	}
}
