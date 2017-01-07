package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a list of words, find pairs of words which when concatenated, forms a palindrome.
 * Input: {"abc", "cba", "c", "c", "dedcba", "bab", ""}
 * Output:	abc, cba
 * 			cba, abc
 * 			c, c
 * 			abc, dedcba
 * 			c, ""
 * 			"", c
 * 			bab, ""
 * 			"", bab
 * 
 * @author Virag
 *
 */
public class PalindromePairs {

	public Set<List<String>> getPalindromaticPairs(List<String> words) {
		Set<List<String>> palindromePairs = new HashSet<List<String>>();

		// map of reverse of words and its indices in the array
		// you need to store the indices, to avoid cases where the word itself is a palindrome
		Map<String, List<Integer>> reverseMap = new HashMap<String, List<Integer>>();
		// proceed only if input is not null and there are 2 or more words in the input
		if(words != null && words.size() > 1) {

			// add reverse of string to the list
			for(int i = 0; i < words.size(); i++) {
				if(reverseMap.containsKey(reverse(words.get(i)))) {
					reverseMap.get(reverse(words.get(i))).add(i);
				}
				else {
					reverseMap.put(reverse(words.get(i)), new ArrayList<Integer>(Arrays.asList(i)));
				}
			}

			// iterate over the words, and find palindrome pairs
			for(String s : words) {

				// get all prefixes and postfixes, and find palindrome pairs
				for(int i = 0; i <= s.length(); i++) {
					String prefix = s.substring(0, i);
					String postfix = s.substring(i);

					if(reverseMap.containsKey(prefix) && isPalindrome(postfix)) {
						// this condition is to avoid the scenario where the word itself is a prefix
						if(!s.equals(reverse(prefix)) || reverseMap.get(prefix).size() > 1) {
							palindromePairs.add(new ArrayList<String>(Arrays.asList(s, reverse(prefix))));
						}
					}

					if(reverseMap.containsKey(postfix) && isPalindrome(prefix)) {
						// this condition is to avoid the scenario where the word itself is a postfix
						if(!s.equals(reverse(postfix)) || reverseMap.get(postfix).size() > 1) {
							palindromePairs.add(new ArrayList<String>(Arrays.asList(reverse(postfix), s)));
						}
					}
				}
			}
		}

		return palindromePairs;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public String reverse(String str) {
		if(str == null || str.trim().length() == 0) {
			return str;
		}
		else {
			return new StringBuilder(str).reverse().toString();
		}
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPalindrome(String str) {
		if(str == null || str.trim().length() == 0) {
			return true;
		}
		else {
			return str.equals(reverse(str));
		}
	}

	public static void main(String[] args) {
		PalindromePairs pairs = new PalindromePairs();
		List<String> words = new ArrayList<String>(Arrays.asList("abc", "cba", "c", "c", "dedcba", "bab", ""));

		Set<List<String>> palindromePairs = pairs.getPalindromaticPairs(words);

		for (List<String> pair : palindromePairs) {
			System.out.println(pair);
		}
	}
}