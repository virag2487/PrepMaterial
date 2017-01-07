package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the longest substring that contains k unique characters.
 * Given "abcadcacacaca" and 3, it returns "cadcacacaca".
 * 
 * @author Virag Shah
 *
 */
public class LongestSubstringWithKDistinctCharacters {

	/**
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int getSizeOfLongestSubstring(String s, int k) {

		if(s == null || s.length() == 0 || k ==0) {
			return 0;
		}

		if(s.length() < k) {
			return s.length();
		}

		Map<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
		int maxLength = 0;
		int startIndex = 0;

		for(int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);
			if(characterCountMap.containsKey(ch)) {
				characterCountMap.put(ch, characterCountMap.get(ch) + 1);
			}
			else {
				characterCountMap.put(ch, 1);
			}

			// as soon as num of characters in map goes above k, bring it down to k
			if(characterCountMap.size() > k) {

				// maintain maxLength throughout
				maxLength = Math.max(maxLength, i - startIndex);

				while(characterCountMap.size() > k) {
					char ch1 = s.charAt(startIndex);

					if(characterCountMap.get(ch1) == 1) {
						characterCountMap.remove(ch);
					}
					else {
						characterCountMap.put(ch1, characterCountMap.get(ch1) - 1);
					}

					startIndex++;
				}
			}
		}

		return Math.max(maxLength, s.length() - startIndex);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubstringWithKDistinctCharacters longestSubstring = new LongestSubstringWithKDistinctCharacters();

		System.out.println(longestSubstring.getSizeOfLongestSubstring("abcadcacacaca", 3));
		System.out.println(longestSubstring.getSizeOfLongestSubstring("abcadcacacaca", 4));
	}
}
