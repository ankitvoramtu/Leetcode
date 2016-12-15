package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		List<String> one = Arrays.asList("0", "1", "8");
		List<String> two = Arrays.asList("");
		List<String> ret;
		if (n % 2 == 1) {
			ret = one;
		} else {
			ret = two;
		}
		for (int i = (n % 2) + 2; i <= n; i += 2) {
			List<String> newList = new ArrayList<>();
			for (String str : ret) {
				if (i != n) {
					newList.add("0" + str + "0");
				}
				newList.add("1" + str + "1");
				newList.add("6" + str + "9");
				newList.add("8" + str + "8");
				newList.add("9" + str + "6");
			}
			ret = newList;
		}
		return ret;
	}
}
