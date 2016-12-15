package problems;

public class ScrambleString {
	/*
	 * ����ʵ��һ����ά��̬�滮����Ŀ���������ά����res[i][j][n]������i��s1����ʼ�ַ���j��s2����ʼ�ַ�����n�ǵ�ǰ���ַ������ȣ�res[
	 * i][j][len]��ʾ������i��j�ֱ�Ϊs1��s2���ĳ���Ϊlen���ַ����ǲ��ǻ�Ϊscramble��
	 * ����ά�������ǽ�������������ʽ��Ҳ������ô������ʷ��Ϣ���õ�res
	 * [i][j][len]���ж�����ǲ������㣬��ʵ���������ǰѵ�ǰs1[i...i+
	 * len-1]�ַ�����һ���ֳ������֣�Ȼ��������������һ������ߺ�s2
	 * [j...j+len-1]��߲����ǲ���scramble���Լ��ұߺ�s2[j...
	 * j+len-1]�ұ߲����ǲ���scramble���ڶ����������ߺ�s2
	 * [j...j+len-1]�ұ߲����ǲ���scramble���Լ��ұߺ�s2[j...
	 * j+len-1]��߲����ǲ���scramble������������������һ�ֳ���
	 * ��˵��s1[i...i+len-1]��s2[j...j+len-1]��scramble��
	 * ���������ж���Щ���Ҳ����ǲ���scramble����������ʷ��Ϣ�ģ���Ϊ����С��n������������Ƕ���ǰ�������ˣ�Ҳ���ǳ����������ѭ������
	 * ����˵������һ�������������s1[i...i+len-1]������len-1������������Щ������ֻҪ��һ�ֳ�������ô����������scramble�ġ�
	 * �ܽ���������ʽ��res[i][j][len] = || (res[i][j][k]&&res[i+k][j+k][len-k] ||
	 * res[i][j+len-k][k]&&res[i+k][j][len-k])
	 * ��������1<=k<len��Ҳ���Ƕ�������len-1�������Ľ���������
	 * ����Ϊ��Ϣ���Ǽ�����ģ�����ÿ������ֻ��Ҫ��������������ɣ����������ʽ����ҪO(len)����Ϊlen-1����������
	 * �����ʱ�临�Ӷ���Ϊ����ά��̬�滮
	 * ����Ҫ����ѭ��������ÿһ����Ҫ����ʱ��������ʽ��������O(n^4)����Ȼ�Ѿ��Ƚϸ��ˣ��������ٲ���ָ�������ģ���̬�滮�����кܴ����µ�
	 * ���ռ临�Ӷ���O(n^3)���������£�
	 */

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		if (s1.length() == 0)
			return true;
		boolean[][][] res = new boolean[s1.length()][s2.length()][s1.length() + 1];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				res[i][j][1] = s1.charAt(i) == s2.charAt(j);
			}
		}
		for (int len = 2; len <= s1.length(); len++) {
			for (int i = 0; i < s1.length() - len + 1; i++) {
				for (int j = 0; j < s2.length() - len + 1; j++) {
					for (int k = 1; k < len; k++) {
						res[i][j][len] |= res[i][j][k]
								&& res[i + k][j + k][len - k]
								|| res[i][j + len - k][k]
								&& res[i + k][j][len - k];
					}
				}
			}
		}
		return res[0][0][s1.length()];
	}

}
