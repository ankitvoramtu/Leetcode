package problems;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath a = new SimplifyPath();
		System.out.println(a.simplifyPath("///"));
	}

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		Deque<String> stack = new LinkedList<String>();
		String[] list = path.split("/");
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(".") || list[i].equals("")) {
				continue;
			}
			if (stack.isEmpty() && list[i].equals("..")) {
				continue;
			}
			if (!stack.isEmpty() && list[i].equals("..")) {
				stack.pop();
			} else {
				stack.push(list[i]);
			}
		}
		String ret = "";
		if (stack.isEmpty()) {
			return "/";
		}
		while (!stack.isEmpty()) {
			String cur = stack.pop();
			ret = "/" + cur + ret;
		}
		return ret;
	}

	public String simplifyPath2(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		LinkedList<String> stack = new LinkedList<String>();
		StringBuilder ret = new StringBuilder();

		int i = 0;
		while (i < path.length()) {
			int index = i;
			StringBuilder tmp = new StringBuilder();
			while (i < path.length() && path.charAt(i) != '/') {
				tmp.append(path.charAt(i));
				i++;
			}
			if (index != i) {
				String str = tmp.toString();
				if (str.equals("..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else if (!str.equals(".")) {
					stack.push(str);
				}
			}
			i++;
		}

		if (!stack.isEmpty()) {
			String[] strs = stack.toArray(new String[stack.size()]);
			for (int j = strs.length - 1; j >= 0; j--) {
				ret.append("/" + strs[j]);
			}
		}
		if (ret.length() == 0) {
			return "/";
		}
		return ret.toString();
	}

}
