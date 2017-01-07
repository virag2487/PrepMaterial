package com.test;

/**
 * 
 * @author Virag Shah
 *
 */
public class Trie {

	/**
	 * Trie Node class
	 *
	 */
	class TrieNode {

		TrieNode[] children;
		boolean isEnd;
		int numOfWordsWithPrefix;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode temp = root;
		word = word.toLowerCase();

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if(temp.children[index] == null) {
				TrieNode t = new TrieNode();
				temp.children[index] = t;
				temp = t;
			}
			else {
				temp = temp.children[index];
			}

			temp.numOfWordsWithPrefix++;
		}
		temp.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode temp = searchNode(word.toLowerCase());
		if(temp == null) {
			return false;
		}
		else {
			if(temp.isEnd) {
				return true;
			}
		}
		return false;
	}

	public boolean startsWith(String prefix) {
		TrieNode temp = searchNode(prefix.toLowerCase());
		if(temp == null) {
			return false;
		}
		else {
			return true;
		}
	}

	public int numOfWordsWithPrefix(String prefix) {
		TrieNode temp = searchNode(prefix.toLowerCase());
		if(temp == null) {
			return 0;
		}
		else {
			return temp.numOfWordsWithPrefix;
		}
	}

	public TrieNode searchNode(String s) {
		TrieNode temp = root;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';

			if(temp.children[index] == null) {
				return null;
			}
			else {
				temp = temp.children[index];
			}
		}

		if(temp == root) {
			return null;
		}

		return temp;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("to");
		trie.insert("tea");
		trie.insert("ted");

		System.out.println("to: " + trie.search("to"));
		System.out.println("tea: " + trie.search("teA"));
		System.out.println("ted: " + trie.search("ted"));
		System.out.println("ten: " + trie.search("Ten"));

		System.out.println("in: " + trie.startsWith("in"));
		System.out.println("inn: " + trie.startsWith("inn"));

		trie.insert("ten");
		trie.insert("in");
		trie.insert("inn");

		System.out.println("ten: " + trie.search("Ten"));
		System.out.println("in: " + trie.search("in"));
		System.out.println("inn: " + trie.search("inn"));

		System.out.println("numOfWordsWithPrefix t: " + trie.numOfWordsWithPrefix("t"));
		System.out.println("numOfWordsWithPrefix in: " + trie.numOfWordsWithPrefix("in"));
	}
}