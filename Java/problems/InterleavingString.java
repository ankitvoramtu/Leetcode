package problems;

public class InterleavingString {
	/*
	 * ��˵˵ά������res[i][j]��ʾ��s1��ǰi���ַ���s2��ǰj���ַ��ܲ��ܰ��չ����ʾ��s3��ǰi+j���ַ���������������res[s1.
	 * length
	 * ()][s2.length()]���ж��Ƿ�Ϊ�漴�ɡ����������ǵ���ʽ�ˣ�����֪��res[i][j]֮ǰ��������ʷ��Ϣ��������ô�õ�res
	 * [i][j]
	 * �����Կ�������ʵֻ�����ַ�ʽ�����ƣ�һ����ѡȡs1���ַ���Ϊs3�¼ӽ������ַ�����һ����ѡs2���ַ���Ϊ�½��ַ�����Ҫ�����ܲ���ѡȡ�������ж�s1
	 * (
	 * s2)�ĵ�i(j)���ַ��Ƿ���s3��i+j���ַ���ȡ��������ѡȡ���Ҷ�Ӧ��res[i-1][j](res[i][j-1])ҲΪ�棬��˵��s3��i
	 * +j���ַ����Ա���ʾ�����������ֻҪ��һ�ֳ�������˵��res[i][j]Ϊ�棬��һ����Ĺ�ϵ�����Ե���ʽ���Ա�ʾ�� res[i][j] =
	 * res[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1) ||
	 * res[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)
	 * ʱ������Ϊ��һ����ά��̬�滮�����Ը��Ӷ���O(m*n)��
	 * m��n�ֱ���s1��s2�ĳ��ȡ������ǿռ仨�ѣ����Կ�������ʽ��ֻ��Ҫ�õ���һ�е���Ϣ����������ֻ��Ҫһ��һά����Ϳ��������ʷ��Ϣ��ά��
	 * ��Ϊ�˸����Ż������ǰѶ̵��ַ��������ڲ�ѭ���������Ϳ���ֻ��Ҫ���ַ����ĳ��ȼ��ɣ����Ը��Ӷ���O(min(m,n))��
	 */

	public boolean isInterleave2(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l3 != l1 + l2) {
			return false;
		}
		boolean[][] ret = new boolean[l1 + 1][l2 + 1];
		ret[0][0] = true;
		for (int j = 0; j < l2; j++) {
			ret[0][j + 1] = ret[0][j] && s2.charAt(j) == s3.charAt(j);
		}
		for (int i = 0; i < l1; i++) {
			ret[i + 1][0] = ret[i][0] && s1.charAt(i) == s3.charAt(i);
		}

		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				ret[i + 1][j + 1] = (ret[i + 1][j] && s2.charAt(j) == s3
						.charAt(i + j + 1))
						|| (ret[i][j + 1] && s1.charAt(i) == s3.charAt(i + j
								+ 1));
			}
		}

		return ret[l1][l2];

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		String minWord = s1.length() > s2.length() ? s2 : s1;
		String maxWord = s1.length() > s2.length() ? s1 : s2;
		boolean[] ret = new boolean[minWord.length() + 1];
		ret[0] = true;
		for (int i = 0; i < minWord.length(); i++) {
			ret[i + 1] = ret[i] && minWord.charAt(i) == s3.charAt(i);
		}
		for (int i = 0; i < maxWord.length(); i++) {
			ret[0] = ret[0] && maxWord.charAt(i) == s3.charAt(i);
			for (int j = 0; j < minWord.length(); j++) {
				ret[j + 1] = ret[j + 1]
						&& maxWord.charAt(i) == s3.charAt(i + j + 1) || ret[j]
						&& minWord.charAt(j) == s3.charAt(i + j + 1);
			}
		}
		return ret[minWord.length()];
	}

}
