package problems;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	// Initialize your data structure here.
	Map<Character, TrieNode> map;
	boolean isLeaf;

	public TrieNode() {
		map = new HashMap<Character, TrieNode>();
		isLeaf = false;
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!cur.map.containsKey(ch)) {
				cur.map.put(ch, new TrieNode());
			}
			cur = cur.map.get(ch);
		}
		cur.isLeaf = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!cur.map.containsKey(ch)) {
				return false;
			}
			cur = cur.map.get(ch);
		}
		return cur.isLeaf;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (!cur.map.containsKey(ch)) {
				return false;
			}
			cur = cur.map.get(ch);
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");