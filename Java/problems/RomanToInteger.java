package problems;

public class RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ret = map(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (map(s.charAt(i)) > map(s.charAt(i - 1))) {
				ret -= map(s.charAt(i - 1)) * 2;
			}
			ret += map(s.charAt(i));
		}
		return ret;
	}

	public int map(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
