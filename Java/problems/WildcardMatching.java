package problems;

public class WildcardMatching {
	/**
	 * ������Ҫ����˵һ�¶�̬�滮�ķ�������Regular Expression
	 * Matchingһ��������ά��һ����������ά��һ����������res[i],����s��ǰi���ַ���p��ǰj���ַ��Ƿ�ƥ��
	 * (������Ϊÿ��i�Ľ��ֻ������j-1�Ľ�������Բ���Ҫ��ά���飬ֻ��Ҫһ��һά������������һ�н�����ɣ������ƹ�ʽ�����������
	 * (1)p[j]����'*'
	 * ������Ƚϼ򵥣�ֻҪ�ж������ǰs��i��p��j�ϵ��ַ�һ���������p��j�ϵ��ַ���'?'��Ҳ����ͬ��������res[i]==true
	 * �������res[i+1]Ϊtrue������res[i+1]=false;
	 * (2)p[j]��'*'����Ϊ'*'����ƥ�������ַ�����������ǰ���res[i]ֻҪ��true����ôʣ�µ� res[i+1],
	 * res[i+2],...,res[s.length()]�Ͷ���true�ˡ� �㷨��ʱ�临�Ӷ���Ϊ������ѭ����������O(m*n),
	 * ���ռ临�Ӷ�ֻ��һ��һά���飬������O(n)������s�ĳ�����n��p�ĳ�����m���������£�
	 */
	public static void main(String[] args) {
		WildcardMatching a = new WildcardMatching();
		System.out.println(a.isMatch("abc", "*a"));
	}

	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;
		boolean[] ret = new boolean[s.length() + 1];
		ret[0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				for (int i = s.length() - 1; i >= 0; i--) {
					ret[i + 1] = ret[i]
							&& (p.charAt(j) == '?' || s.charAt(i) == p
									.charAt(j));
				}
			} else {
				int i = 0;
				while (i <= s.length() && !ret[i])
					i++;
				for (; i <= s.length(); i++) {
					ret[i] = true;
				}
			}
			ret[0] = ret[0] && p.charAt(j) == '*';
		}
		return ret[s.length()];
	}
}
