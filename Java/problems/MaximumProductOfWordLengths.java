package problems;

public class MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		int[] val = new int[words.length];
		for (int i = 0; i < val.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				val[i] |= (1 << (words[i].charAt(j) - 'a'));
			}
		}
		int ret = 0;
		for (int i = 0; i < val.length - 1; i++) {
			for (int j = i + 1; j < val.length; j++) {
				if ((val[i] & val[j]) == 0
						&& words[i].length() * words[j].length() > ret) {
					ret = words[i].length() * words[j].length();
				}
			}
		}
		return ret;
	}

}
