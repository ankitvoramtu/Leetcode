package problems;

public class StringtoInteger {
	/**
	 * ������Ŀ����ص㲢���������Ȿ������Ҫע��corner
	 * case�Ĵ�������һ�������㣬һ���������������⣬��һ��������Խ�����⡣˼·�Ƚϼ򵥣�������ȥ������Ŀո��ַ�
	 * ��Ȼ������ţ�ע�������Ŷ��п��ܣ�Ҳ�п���û�з���
	 * ������������˳������֣����������������������1���쳣�ַ����֣�����C���Եı�׼�ǰ��쳣�ַ���ĺ���ȫ����ȥ
	 * ������ǰ��Ĳ�����Ϊ���������2������Խ�磨������ӽ�������������3���ַ���������
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
