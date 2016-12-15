package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return ret;
		}
		for (int i = 1; i < 4; i++) {
			String first = s.substring(0, i);
			if (!isValid(first)) {
				continue;
			}
			for (int j = 1; j < 4 && (i + j) < s.length(); j++) {
				String second = s.substring(i, i + j);
				if (!isValid(second)) {
					continue;
				}
				for (int k = 1; k < 4 && (i + j + k) < s.length(); k++) {
					String third = s.substring(i + j, i + j + k);
					String fourth = s.substring(i + j + k);
					if (!isValid(third) || !isValid(fourth)) {
						continue;
					}
					String tmp = first + '.' + second + '.' + third + '.'
							+ fourth;
					ret.add(tmp);
				}
			}
		}
		return ret;
	}

	public List<String> restoreIpAddresses2(String s) {
		List<String> ret = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return ret;
		}
		helper(ret, s, "", 0, 1);
		return ret;
	}

	public void helper(List<String> ret, String s, String item, int index,
			int segment) {
		if (index >= s.length()) {
			return;
		}
		if (segment == 4) {
			String str = s.substring(index);
			if (isValid(str)) {
				ret.add(item + "." + str);
			}
			return;
		}
		for (int i = 1; i < 4 && (index + i <= s.length()); i++) {
			String str = s.substring(index, index + i);
			if (isValid(str)) {
				if (segment == 1) {
					helper(ret, s, str, index + i, segment + 1);
				} else {
					helper(ret, s, item + "." + str, index + i, segment + 1);

				}
			}
		}

	}

	private boolean isValid(String str) {
		if (str == null || str.length() > 3) {
			return false;
		}
		if (str.charAt(0) == '0' && str.length() > 1) {
			return false;
		}
		int num = Integer.parseInt(str);
		if (num >= 0 && num <= 255) {
			return true;
		}
		return false;
	}

	public List<String> restoreIpAddresses3(String s) {
		List<String> ret = new LinkedList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return ret;
		}
		helper3(ret, s, new String(), 0, 0);
		return ret;

	}

	public void helper3(List<String> ret, String s, String tmp, int start,
			int section) {
		if (start == s.length() && section == 4) {
			ret.add(new String(tmp.substring(0, tmp.length() - 1)));
			return;
		}
		for (int i = start; i < start + 3; i++) {
			if (i >= s.length()) {
				return;
			}
			if (s.charAt(start) == '0' && i > start) {
				return;
			}
			int val = 0;
			for (int j = start; j <= i; j++) {
				val = val * 10 + (s.charAt(j) - '0');
			}
			if (val <= 255) {
				helper(ret, s, tmp + Integer.toString(val) + '.', i + 1,
						section + 1);
			}
		}
	}

}
