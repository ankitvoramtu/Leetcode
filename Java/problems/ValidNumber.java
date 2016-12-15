package problems;

public class ValidNumber {
	/*
	 * ����һ������ַ��������Ƿ�Ϊ�Ϸ�����Ŀ�����������ǰ��տ�ѧ�����������Ի���ֵ������ַ������¼���������λ��+������-����С���㡮.�������С�e���͡�
	 * E����ʣ�µľ�ֻ������0-9�ˣ������ַ�������־��ǷǷ��ַ�������false�������ַ���������ֶ���ok�ģ�������Ҫ���Ǽ��������ַ��������
	 * ����С������ֵ�ʱ��
	 * ������Ҫ����һ����Щ��������1��ǰ�治����С������ߡ�e���͡�E������2��ǰһλ�����֣������ǵ�һλ�����ߺ�һλҪ�����֣����������һλ����
	 * ���������ų��ֵ������Ҫ������������1�������ǵ�һλ�����ڡ�e���͡�E����һλ����2����һλҪ�����֡�
	 * ���ڡ�e���͡�E���������Ҫ���㣺��1��ǰ�治����
	 * ��e���͡�E�����ֹ�����2�������ǵ�һλ��ǰ��û���ֿ�ѧ����û�����壩�������һλ������û���־Ͳ���дָ���ˣ���
	 * ���������оٵ������������������ǩ����ǰ��λ���ж���ʵ�֣��㷨���ӶȱȽ�������O(n)�ģ�ֻ��ҪO(1)�Ķ���ռ䡣�������£�
	 */

	public static void main(String[] args) {
		ValidNumber a = new ValidNumber();
		System.out.println(a.isNumber(".1"));
		System.out.println(a.isNumber("."));
		System.out.println(a.isNumber("3."));
		System.out.println(a.isNumber("+.8"));
	}

	public boolean isNumber(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			i++;
		}
		boolean isNumeric = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		if (isNumeric && i < n && s.charAt(i) == 'e') {
			i++;
			isNumeric = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				i++;
			}
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return isNumeric && i == n;
	}

	public boolean isNumber1(String s) {
		if (s == null) {
			return false;
		}
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		boolean dotFlag = false;
		boolean eFlag = false;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '.':
				if (dotFlag || eFlag) {
					return false;
				}
				if (((i == 0 || !(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) && (i == s
						.length() - 1 || !(s.charAt(i + 1) >= '0' && s
						.charAt(i + 1) <= '9'))))
					return false;
				dotFlag = true;
				break;
			case '+':
			case '-':
				if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
					return false;
				}
				if (i == s.length() - 1
						|| !(s.charAt(i + 1) == '.' || (s.charAt(i + 1) >= '0' && s
								.charAt(i + 1) <= '9'))) {
					return false;
				}
				break;
			case 'E':
			case 'e':
				if (eFlag || i == 0 || i == s.length() - 1) {
					return false;
				}
				eFlag = true;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				break;
			default:
				return false;
			}
		}
		return true;
	}
}
