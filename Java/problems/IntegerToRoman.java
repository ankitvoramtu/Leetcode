package problems;

public class IntegerToRoman {
	public String intToRoman(int num) {
		int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
				4, 1 };
		String[] str = new String[] { "M", "CM", "D", "CD", "C", "XC", "L",
				"XL", "X", "IX", "V", "IV", "I" };

		int i = 0;
		StringBuilder ret = new StringBuilder();
		while (num > 0) {
			if (num >= val[i]) {
				ret.append(str[i]);
				num = num - val[i];
			} else {
				i++;
			}
		}
		return ret.toString();
	}

}
