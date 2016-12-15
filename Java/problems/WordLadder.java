package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {
		WordLadder a = new WordLadder();
		Set<String> set = new HashSet<String>();
		set.add("hot");
		int ret = a.ladderLength("hot", "hot", set);
		System.out.println(ret);
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordDict) {
		if (beginWord == null || endWord == null || beginWord.length() == 0
				|| endWord.length() == 0
				|| beginWord.length() != endWord.length()) {
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		int level = 1;
		int lastNum = 1;
		int curNum = 0;
		queue.offer(beginWord);
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			lastNum--;
			for (int i = 0; i < cur.length(); i++) {
				char[] charCur = cur.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					charCur[i] = c;
					String temp = new String(charCur);
					if (temp.equals(endWord)) {
						return level + 1;
					}
					if (wordDict.contains(temp) && !visited.contains(temp)) {
						curNum++;
						queue.offer(temp);
						visited.add(temp);
					}
				}
			}
			if (lastNum == 0) {
				lastNum = curNum;
				curNum = 0;
				level++;
			}
		}
		return 0;
	}
}
