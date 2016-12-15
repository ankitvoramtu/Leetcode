package problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return ret;
		}
		ret.add("");
		int digitsLen = digits.length();
		for (int i = 0; i < digitsLen; i++) {
			String letter = getLetters(digits.charAt(i));
			List<String> cur = new ArrayList<String>();
			int letterLen = letter.length();
			for (int j = 0; j < ret.size(); j++) {
				for (int k = 0; k < letterLen; k++) {
					cur.add(ret.get(j) + letter.charAt(k));
				}
			}
			ret = cur;
		}
		return ret;
	}

	public String getLetters(char digit) {
		switch (digit) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		case '0':
			return "";
		case '1':
			return "";
		default:
			return "";
		}
	}
}
