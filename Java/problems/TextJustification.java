package problems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> ret = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return ret;
		}
		int last = 0;
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			int spaceNum = 0;
			int extraNum = 0;
			if (count + words[i].length() + (i - last) > L) {
				if (i - last > 1) {
					spaceNum = (L - count) / (i - last - 1);
					extraNum = (L - count) % (i - last - 1);
				}
				StringBuilder str = new StringBuilder();
				for (int j = last; j < i; j++) {
					str.append(words[j]);
					if (j < i - 1) {
						for (int k = 0; k < spaceNum; k++) {
							str.append(" ");
						}
						if (extraNum > 0) {
							str.append(" ");
						}
						extraNum--;
					}
				}
				for (int j = str.length(); j < L; j++) {
					str.append(" ");
				}
				ret.add(str.toString());
				last = i;
				count = 0;
			}
			count += words[i].length();
		}
		StringBuilder str = new StringBuilder();
		for (int i = last; i < words.length; i++) {
			str.append(words[i]);
			if (str.length() < L) {
				str.append(" ");
			}
		}
		for (int i = str.length(); i < L; i++) {
			str.append(" ");
		}
		ret.add(str.toString());
		return ret;
	}
}
