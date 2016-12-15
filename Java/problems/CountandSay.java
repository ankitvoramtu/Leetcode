package problems;

public class CountandSay {
	public static void main(String[] args) {

		CountandSay a = new CountandSay();
		System.out.println(a.countAndSay(6));
	}

	public String countAndSay(int n) {
		if (n < 1) {
			return "";
		}
		String ret = "1";
		for (int i = 2; i <= n; i++) {
			int count = 1;
			String cur = new String();
			for (int j = 1; j < ret.length(); j++) {
				if (ret.charAt(j) == ret.charAt(j - 1)) {
					count++;
				} else {
					cur += count;
					cur += ret.charAt(j - 1);
					count = 1;
				}
			}
			cur += count;
			cur += ret.charAt(ret.length() - 1);
			ret = cur;
		}
		return ret;
	}
}
