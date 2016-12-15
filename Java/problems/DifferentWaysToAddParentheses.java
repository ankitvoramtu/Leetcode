package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

	public List<Integer> diffWaysToCompute(String input) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		return helper(input, map);
	}

	public List<Integer> helper(String input, Map<String, List<Integer>> map) {
		List<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (isSign(input.charAt(i))) {
				String s1 = input.substring(0, i);
				String s2 = input.substring(i + 1);
				List<Integer> l1;
				if (map.containsKey(s1)) {
					l1 = map.get(s1);
				} else {
					l1 = helper(s1, map);
				}
				List<Integer> l2;
				if (map.containsKey(s2)) {
					l2 = map.get(s2);
				} else {
					l2 = helper(s2, map);
				}
				for (Integer i1 : l1) {
					for (Integer i2 : l2) {
						int r = 0;
						switch (input.charAt(i)) {
						case '+':
							r = i1 + i2;
							break;
						case '-':
							r = i1 - i2;
							break;
						case '*':
							r = i1 * i2;
							break;
						}
						ret.add(r);
					}
				}
			}
		}
		if (ret.size() == 0) {
			ret.add(Integer.parseInt(input));
		}
		map.put(input, ret);
		return ret;
	}

	public boolean isSign(char c) {
		return c == '+' || c == '-' || c == '*';
	}

}
