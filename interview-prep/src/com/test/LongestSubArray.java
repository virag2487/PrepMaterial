package com.test;

import java.util.Arrays;

public class LongestSubArray {

	public static void main(String[] args) {
		LongestSubArray lsa = new LongestSubArray();
		int[] a = {1,2,3};
		int[] b = {3,1,2,1};
		int[] c = {74,659,931,273,545,879,924,710,441,166,493,43,988,504,328,730,841,613,304,170,710,158,561,934,100,279,817,336,98,827,513,268,811,634,980,150,580,822,968,673,394,337,486,746,229,92,195,358,2,154,709,945,669,491,125,197,531,904,723,667,550};
		int longestSubArray = lsa.maxSubArray(a, 4);
		System.out.println(longestSubArray);
		longestSubArray = lsa.maxSubArray(b, 4);
		System.out.println(longestSubArray);
		longestSubArray = lsa.maxSubArray(c, 22337);
		System.out.println(longestSubArray);
	}

	public int maxSubArray(int[] a, int k) {
		int length = a.length;
		int longestSubArray = 0;
		for(int i = 0; i < length; i++) {
			for(int j = i; j < length; j++) {
				int[] temp = Arrays.copyOfRange(a, i, j + 1);

				int sum = 0;
				for(int n = 0; n < temp.length; n++) {
					sum += temp[n];
				}

				if(sum <=k && temp.length > longestSubArray) {
					longestSubArray = temp.length;
				}
			}
		}
		return longestSubArray;
	}
}
