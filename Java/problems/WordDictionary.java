package problems;

import java.util.HashMap;

public class WordDictionary {
	class TrieNode {
		HashMap<Character, TrieNode> map;
		boolean isEnd;

		TrieNode() {
			map = new HashMap<Character, TrieNode>();
			isEnd = false;
		}
	}

	TrieNode root;

	WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.map.containsKey(ch)) {
				node.map.put(ch, new TrieNode());
			}
			node = node.map.get(ch);
		}
		node.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return search(word, root, 0);
	}

	public boolean search(String word, TrieNode node, int index) {
		if (index == word.length()) {
			return node.isEnd;
		}
		char ch = word.charAt(index);
		if (ch == '.') {
			for (TrieNode n : node.map.values()) {
				if (search(word, n, index + 1)) {
					return true;
				}
			}
			return false;
		}
		if (!node.map.containsKey(ch)) {
			return false;
		}
		return search(word, node.map.get(ch), index + 1);

	}
}
