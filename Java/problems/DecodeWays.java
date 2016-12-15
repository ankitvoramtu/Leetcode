package problems;

public class DecodeWays {
	/*
	 * ����ά������res[i]�Ǳ�ʾǰi�������ж����ֽ����ķ�ʽ��������������ݹ�ʽ�������ַ�ʽ����һ���¼ӽ��������ֲ�Ȼ�����Լ��Ƚϱ�ʾһ���ַ���
	 * ��ô�����ķ�ʽ��res
	 * [i-1]�֣��ڶ��־����¼ӽ��������ֺ�ǰһ�����ִճ�һ���ַ��������ķ�ʽ��res[i-2]�֣���Ϊ��һ���ַ����Լ��ճ���һ��
	 * ������Ȼ����Ҫ�ж�ǰ��˵����������ܷ�ճ�һ���ַ�
	 * ��Ҳ���Ƿ�Χ���жϣ�������Բ��ж�Ӧ�Ľ�����ʽ��������У���ô����0�����ս�����ǰ������������Ӧ�Ľ�����ʽ��ӡ�������԰ѷ�Χ�ֳɼ������䣺
	 * ��1��00��res[i]=0���޷�������û�п��н�����ʽ����
	 * 
	 * ��2��10, 20��res[i]=res[i-2]��ֻ�еڶ��������������
	 * 
	 * ��3��11-19, 21-26��res[i]=res[i-1]+res[i-2]��������������У���
	 * 
	 * ��4��01-09, 27-99��res[i]=res[i-1]��ֻ�е�һ��������У���
	 * 
	 * (5) 30, 40, 50 is all invalid
	 */

	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int num1 = 1;  // this is tricky
		int num2 = 1;
		int num3;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
					num3 = num1;
				} else {
					return 0;
				}
			} else {
				if (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3') {
					num3 = num2;
				} else {
					if (s.charAt(i - 1) == '2' && s.charAt(i) >= '7'
							&& s.charAt(i) <= '9') {
						num3 = num2;
					} else {
						num3 = num1 + num2;
					}
				}
			}
			num1 = num2;
			num2 = num3;
		}
		return num2;
	}
}