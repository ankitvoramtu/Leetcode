package problems;

public class MultiplyStrings {
	/**
	 * �����������ֵ��������Ŀ����ʵ������ǿ���˷�����ı��ʡ�����˼·�Ǻͼӷ����㻹�ǽ��Ƶģ�ֻ�ǽ�λ�ͽ�����ȸ���һЩ��
	 * ������Ȼ�Ǵӵ�λ����λ��ÿһλ���м���
	 * �������һ����������n���ڶ�����������m������֪���������Ϊm+n����m+n-1��û�н�λ�������������ĳһλi
	 * ��Ҫ�������λ�ϵ����֣�������Ҫ����������ϳ���һλ�����λ���г˷�������1λ�͵�iλ����2λ�͵�i-1λ��...
	 * ��Ȼ���ۼ��������������ȡ��λ�ϵ���ֵ
	 * ��Ȼ��ʣ�µ���Ϊ��λ�ŵ���һ��ѭ���С�����㷨����ѭ����ÿ��ѭ��������O(m+n)������ʱ�临�Ӷ���O((m+
	 * n)^2)���㷨�в���Ҫ����ռ䣬ֻ��Ҫά��һ����λ�������ɣ����Կռ临�Ӷ���O(1)��
	 */

	public static void main(String[] args) {
		MultiplyStrings a = new MultiplyStrings();
		// System.out.println(a.multiply("98", "9"));
		System.out.println(a.multiply("6", "501"));
		// System.out.println(a.multiply(
		// "61480723987857250303867015585644902996295272",
		// "17149437458129895288707346085"));
	}

	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			return "";
		}
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
			return "0";
		}
		int l1 = num1.length();
		int l2 = num2.length();
		StringBuilder ret = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < l1 + l2 - 1; i++) {
			for (int j = 0; j <= i; j++) {
				int k = i - j;
				if (j < l1 && k < l2) {
					int v1 = (int) (num1.charAt(l1 - 1 - j) - '0');
					int v2 = (int) (num2.charAt(l2 - 1 - k) - '0');
					carry += v1 * v2;
				}
			}
			ret.append(carry % 10);
			carry = carry / 10;
		}
		if (carry != 0) {
			ret.append(carry);
		}
		return ret.reverse().toString();
	}

}
