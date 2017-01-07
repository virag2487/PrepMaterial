package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 * 
 * @author Virag 
 *
 */
public class SmallestSubstring {

	public String findSmallestSubstring(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() < s2.length()) {
			return "";
		}

		// generate total characters to be found with their counts
		Map<Character, Integer> needToFind = new HashMap<Character, Integer>();

		for(int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if(needToFind.containsKey(ch)) {
				needToFind.put(ch, needToFind.get(ch) + 1);
			}
			else {
				needToFind.put(ch, 1);
			}
		}

		String result = "";
		int minLength = Integer.MAX_VALUE;
		int countOfCharactersFound = 0;
		int startIndex = 0;
		Map<Character, Integer> found = new HashMap<Character, Integer>();

		// Iterate through the given long string and keep track of characters found
		for(int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if(found.containsKey(ch)) {
				found.put(ch, found.get(ch) + 1);
			}
			else {
				found.put(ch, 1);
			}

			// increment counter as soon as you find a one of the characters from string 2
			if(needToFind.containsKey(ch) && (found.get(ch) <= needToFind.get(ch))) {
				countOfCharactersFound++;
			}

			// when all characters are found, try to find the shortest string match
			if(countOfCharactersFound == s2.length()) {
				char c = s1.charAt(startIndex);
				while(!needToFind.containsKey(c) || found.get(c) > needToFind.get(c)) {
					found.put(c, found.get(c) - 1);
					startIndex++;
					c = s1.charAt(startIndex);
				}

				if(i - startIndex + 1 < minLength) {
					minLength = i - startIndex + 1;
					result = s1.substring(startIndex, i + 1);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SmallestSubstring sWindow = new SmallestSubstring();
		String s1 = "this is a test string";
		String s2 = "tist";

		System.out.println("Smallest substring: " + sWindow.findSmallestSubstring(s1, s2));

		s1 = "ADOBECODEBANC";
		s2 = "ABC";

		System.out.println("Smallest substring: " + sWindow.findSmallestSubstring(s1, s2));

		s1 = "hello what are you doing";
		s2 = "eo";

		System.out.println("Smallest substring: " + sWindow.findSmallestSubstring(s1, s2));

		s1 = "acbbaca";
		s2 = "aba";

		System.out.println("Smallest substring: " + sWindow.findSmallestSubstring(s1, s2));

		s1 = "abcdefghijklmnopqrstuvwxyz";
		s2 = "alz";

		System.out.println("Smallest substring: " + sWindow.findSmallestSubstring(s1, s2));
	}
}
