package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array and a number, return true if array contains 2 numbers whose sum is the given number, else return false
 * 
 * @author Virag Shah
 *
 */
public class SumOfTwoNumbersInArray {

	public boolean sumOfTwoNumbers(int[] arr, int sum) {

		boolean result = false;

		if(arr == null || arr.length == 0) {
			return result;
		}

		Map<Integer, Integer> nums = new HashMap<Integer, Integer>();

		for(int i = 0; i < arr.length; i++) {
			if(nums.containsKey(arr[i])) {
				nums.put(arr[i], nums.get(arr[i]) + 1);
			}
			else {
				nums.put(arr[i], 1);
			}
		}

		for(Map.Entry<Integer, Integer> entry : nums.entrySet()) {
			if(nums.containsKey(sum - entry.getKey())) {

				if(sum - entry.getKey() != entry.getKey()) {
					result = true;
					break;
				}

				if(sum - entry.getKey() == entry.getKey() && entry.getValue() > 1) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	public boolean sumOfThreeNumbers1(int[] arr, int sum) {
		boolean result = false;

		if(arr == null || arr.length == 0) {
			return result;
		}

		Arrays.sort(arr);

		int j, k;

		for(int i = 0; i < arr.length; i++) {

			j = i + 1;
			k = arr.length - 1;

			while(j < k) {

				if(arr[i] + arr[j] + arr[k] == sum) {
					result = true;
					break;
				}
				else if(arr[i] + arr[j] + arr[k] < sum) {
					j++;
				}
				else {
					k--;
				}
			}
		}
		return result;
	}

	public boolean sumOfThreeNumbers2(int[] arr, int sum) {
		boolean result = false;

		if(arr == null || arr.length == 0) {
			return result;
		}

		for(int i = 0; i < arr.length; i++) {
			// TODO remove the element from arr before calling sumOfTwoNumbers
			if(sumOfTwoNumbers(arr, (sum - arr[i]))) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SumOfTwoNumbersInArray sum = new SumOfTwoNumbersInArray();

		int[] arr1 = {1, 38, 4, 4, 5, 9, 2};
		System.out.println(sum.sumOfTwoNumbers(arr1, 4));

		int[] arr2 = {1, 38, 4, 4, 5, 9, 2, 2};
		System.out.println(sum.sumOfTwoNumbers(arr2, 4));

		int[] arr3 = {1, 38, 4, 4, 5, 9, 2};
		System.out.println(sum.sumOfThreeNumbers1(arr3, 16));

		// Should return false
		// fix todo at line 93 to fix this method
		int[] arr4 = {1, 38, 4, 4, 5, 9, 2};
		System.out.println(sum.sumOfThreeNumbers2(arr4, 40));
	}
}
