package problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ret = new ArrayList<String>();
		for (int j = s.length() - 1; j >= 0; j--) {
			if (wordDict.contains(s.substring(j)))
				break;
			else {
				if (j == 0)
					return ret;
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {
				List<String> strs = wordBreak(s.substring(i + 1, s.length()),
						wordDict);
				if (strs.size() != 0)
					for (Iterator<String> it = strs.iterator(); it.hasNext();) {
						ret.add(s.substring(0, i + 1) + " " + it.next());
					}
			}
		}
		if (wordDict.contains(s)) {
			ret.add(s);
		}
		return ret;
	}
}
