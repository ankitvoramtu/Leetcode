package problems;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int p1 = s.length() - 1;
		while (p1 >= 0 && s.charAt(p1) == ' ') {
			p1--;
		}
		int p2 = p1;
		while (p2 >= 0 && s.charAt(p2) != ' ') {
			p2--;
		}
		return p1 - p2;
	}
}
