package problems;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> ret = new ArrayList<String>();
		helper(ret, word, 0, "", 0);

		return ret;
	}

	private void helper(List<String> ret, String word, int pos, String tmp,
			int count) {
		if (pos == word.length()) {
			if (count > 0) {
				tmp += count;
			}
			ret.add(tmp);
		} else {
			//choose to abbr word[pos]
			helper(ret, word, pos + 1, tmp, count + 1);
			
			//choose not to abbr word[pos]
			//first append previous count to sb if count>0
			helper(ret, word, pos + 1,
					tmp + (count > 0 ? count : "") + word.charAt(pos), 0);
		}
	}

}
