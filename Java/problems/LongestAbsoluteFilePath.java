package problems;

import java.util.Deque;
import java.util.LinkedList;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		LongestAbsoluteFilePath a = new LongestAbsoluteFilePath();
		int ret = a
				.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
		System.out.println(ret);
	}

	public int lengthLongestPath(String input) {
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(0); // "dummy" length
		int maxLen = 0;
		for (String s : input.split("\n")) {
			int lev = s.lastIndexOf("\t") + 1; // number of "\t"
			while (lev + 1 < stack.size()) {
				stack.pop(); // find parent
			}
			int len = stack.peek() + s.length() - lev + 1; // remove "/t",
															// add"/"
			stack.push(len);
			// check if it is file
			if (s.contains(".")) {
				maxLen = Math.max(maxLen, len - 1);
			}
		}
		return maxLen;
	}
}
