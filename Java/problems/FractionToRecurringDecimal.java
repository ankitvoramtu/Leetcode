package problems;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return "0";
		}
		String ret = "";
		if ((numerator > 0 && denominator < 0)
				|| (numerator < 0 && denominator > 0)) {
			ret += "-";
		}
		long num = Math.abs((long) numerator);
		long denom = Math.abs((long) denominator);
		ret += (num / denom);
		long reminder = num % denom;
		if (reminder == 0) {
			return ret;
		}
		ret += ".";
		reminder = reminder * 10;
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while (reminder != 0) {
			map.put(reminder, ret.length());
			ret += reminder / denom;
			reminder = (reminder % denom) * 10;
			if (map.containsKey(reminder)) {
				int idx1 = map.get(reminder);
				int idx2 = ret.length();
				String part1 = ret.substring(0, idx1);
				String part2 = ret.substring(idx1, idx2);
				return part1 + "(" + part2 + ")";
			}
		}
		return ret;
	}
}
