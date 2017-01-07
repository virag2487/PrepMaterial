package com.test;

/**
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
 * such that the integers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, 
 * then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) 
 * and if the input array is {10, 5, 4, 3}, then output should be 10
 * 
 * @author Virag Shah
 *
 */
public class MaximumSumIncreasingSubsequence {

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public int maximumSumIncreasingSubsequence(int[] arr, int n) {

		int[] msis = new int[n];

		// initialize MSIS values for all indexes 
		for(int i = 0; i < n; i++) {
			msis[i] = arr[i];
		}

		// compute MSIS values in bottom up manner
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				// current num should be greater previous nums and the MSIS value for current index should be less than previous + current num
				if(arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
					msis[i] = msis[j] + arr[i];
				}
			}
		}

		// pick the max of all MSIS values
		int maxMsis = 0;
		for(int i = 0; i < n; i++) {
			maxMsis = Math.max(maxMsis, msis[i]);
		}

		return maxMsis;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumSumIncreasingSubsequence sum = new MaximumSumIncreasingSubsequence();

		int[] arr1 = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(sum.maximumSumIncreasingSubsequence(arr1, 7));

		int[] arr2 = {3, 4, 5, 10};
		System.out.println(sum.maximumSumIncreasingSubsequence(arr2, 4));

		int[] arr3 = {10, 5, 4, 3};
		System.out.println(sum.maximumSumIncreasingSubsequence(arr3, 4));
	}
}
