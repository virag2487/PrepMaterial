package com.test;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence 
 * such that all elements of the subsequence are sorted in increasing order. For example, 
 * the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 * 
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 * 
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 * 
 * @author Virag Shah
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public int longestIncreasingSubsequence(int[] arr, int n) {

		int[] lis = new int[n];

		// initialize LIS for all indexes
		for(int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		// compute LIS values in bottom up manner
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				// current num should be greater previous nums and the LIS value for current index should be less than previous + 1
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		// pick the max of all LIS values
		int maxLis = 1;
		for(int i = 0; i < n; i++) {
			maxLis = Math.max(maxLis, lis[i]);
		}

		return maxLis;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

		int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(lis.longestIncreasingSubsequence(arr1, 9));

		int[] arr2 = {3, 10, 2, 1, 20};
		System.out.println(lis.longestIncreasingSubsequence(arr2, 5));

		int[] arr3 = {3, 2};
		System.out.println(lis.longestIncreasingSubsequence(arr3, 2));

		int[] arr4 = {50, 3, 10, 7, 40, 80};
		System.out.println(lis.longestIncreasingSubsequence(arr4, 6));
	}
}
