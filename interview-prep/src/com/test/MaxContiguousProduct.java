package com.test;

/**
 * Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
 * 
 * Input: arr[] = {6, -3, -10, 0, 2}
 * Output:   180  // The subarray is {6, -3, -10}
 * 
 * Input: arr[] = {-1, -3, -10, 0, 60}
 * Output:   60  // The subarray is {60}
 * 
 * Input: arr[] = {-2, -3, 0, -2, -40}
 * Output:   80  // The subarray is {-2, -40}
 * 
 * @author Virag Shah
 *
 */
public class MaxContiguousProduct {

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public int maxContiguousProduct(int[] arr) {

		if(arr == null || arr.length == 0) {
			return 0;
		}

		// This is similar to maximum subarray. Instead of sum, the sign of number affect the product value.
		// When iterating the array, each element has two possibilities: positive number or negative number. 
		// We need to track a minimum value, so that when a negative number is given, it can also find the maximum value. 
		// We define two local variables, one tracks the maximum and the other tracks the minimum.

		int[] tempMaxProduct = new int[arr.length];
		int[] tempMinProduct = new int[arr.length];

		tempMaxProduct[0] = arr[0];
		tempMinProduct[0] = arr[0];
		int maxProduct = arr[0];

		for(int i = 1; i < arr.length; i++) {

			if(arr[i] > 0) {
				tempMaxProduct[i] = Math.max(tempMaxProduct[i - 1] * arr[i], arr[i]);
				tempMinProduct[i] = Math.min(tempMinProduct[i - 1] * arr[i], arr[i]);
			}
			else {
				tempMaxProduct[i] = Math.max(tempMinProduct[i - 1] * arr[i], arr[i]);
				tempMinProduct[i] = Math.min(tempMaxProduct[i - 1] * arr[i], arr[i]);
			}

			maxProduct = Math.max(tempMaxProduct[i], maxProduct);
		}

		return maxProduct;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MaxContiguousProduct product = new MaxContiguousProduct();

		System.out.println(product.maxContiguousProduct(null));
		System.out.println(product.maxContiguousProduct(new int[]{1}));
		System.out.println(product.maxContiguousProduct(new int[]{-1}));

		int[] arr1 = {6, -3, -10, 0, 2};
		System.out.println(product.maxContiguousProduct(arr1));

		int[] arr2 = {-1, -3, -10, 0, 60};
		System.out.println(product.maxContiguousProduct(arr2));

		int[] arr3 = {-2, -3, 0, -2, -40};
		System.out.println(product.maxContiguousProduct(arr3));
	}
}
