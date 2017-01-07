package com.test;

import java.util.Arrays;

/**
 * An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.
 * 
 * Input: {1, 60, -10, 70, -80, 85}
 * Output: -80 and 85
 * 
 * @author Virag Shah
 *
 */
public class SumClosestToZero {

	// Brute force method: For each element, find the sum of it with every other element in the array and compare sums. 
	// Finally, return the minimum sum. O(N^2)
	// Below is optimized solution O(NlogN)
	/**
	 * 
	 * @param arr
	 */
	public void sumClosestToZero(int[] arr) {

		if(arr == null || arr.length < 2) {
			System.out.println("ERROR: Array should have atleast 2 elements.");
			return;
		}

		// sort the input array
		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;
		int minSum = Integer.MAX_VALUE;
		int num1Index = 0;
		int num2Index = 0;

		while(i < j) {

			int sum = arr[i] + arr[j];

			if(Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				num1Index = i;
				num2Index = j;
			}

			if(sum < 0) {
				i++;
			}
			else {
				j--;
			}
		}

		System.out.println("Min Sum is " + minSum + " and the two numbers are " + arr[num1Index] + " and " + arr[num2Index]);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SumClosestToZero sum = new SumClosestToZero();

		sum.sumClosestToZero(null);
		sum.sumClosestToZero(new int[]{1});

		int[] arr1 = {1, 60, -10, 70, -80, 85};
		sum.sumClosestToZero(arr1);
	}
}