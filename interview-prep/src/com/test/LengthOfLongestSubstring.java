package com.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * Example 1: 
 *      Input: "abcabcbb" 
 *      Output: 3 
 *      Explanation: The answer is "abc", with the length of 3. 
 * Example 2: 
 *      Input: "bbbbb" 
 *      Output: 1 
 *      Explanation: The answer is "b", with the length of 1. 
 * Example 3: 
 *      Input: "pwwkew" 
 *      Output: 3 
 *      Explanation: The answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author virag.shah
 */
public class LengthOfLongestSubstring {

    /**
     * Brute force solution in O(n^3)
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        if(s.length() == 1) {
            return 1;
        }

        int maxLength = 0;
        Set<String> subStrings = new HashSet<String>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                // needed so that repeated strings are executed only once
                if(!subStrings.contains(sub)) {
                    boolean unique = isAllUnique(sub);
                    if(unique) {
                        if(sub.length() > maxLength) {
                            maxLength = sub.length();
                        }
                    }
                    // needed so that if a substring is non unique the remaining substrings starting with that index will be non unique too
                    else {
                        break;
                    }
                }
                subStrings.add(sub);
            }
        }
        return maxLength;
    }

    /**
     * Returns true iff all characters of a String are unique, false otherwise
     * @param s
     * @return
     */
    public boolean isAllUnique(String s) {
        Set<Character> characters = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(characters.contains(s.charAt(i))) {
                return false;
            }
            else {
                characters.add(s.charAt(i));
            }
        }

        return true;
    }
    
    /**
     * This is a better optimized solution in O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
