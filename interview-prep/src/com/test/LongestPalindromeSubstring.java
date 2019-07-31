package com.test;

/** 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000. 
 * Example 1: 
 *      Input: "babad" 
 *      Output: "bab" Note: "aba" is also a valid answer. 
 * Example 2: 
 *      Input: "cbbd"
 *      Output: "bb"
 *
 * @author virag.shah
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        String result = "";

        if(s == null || s.length() == 0) {
            return result;
        }

        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {

                String sub = s.substring(i, j);
                boolean isPalindrome = sub.equals(new StringBuilder(sub).reverse().toString());
                if(isPalindrome) {
                    if(sub.length() > result.length()) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
}
