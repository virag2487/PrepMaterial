package com.test;

/**
 * An element in a sorted array can be found in O(log n) time via binary search. 
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 * 
 * @author Virag Shah
 *
 */
public class BinarySearchInSortedRotatedArray {

	/**
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param num
	 * @return
	 */
	public int search(int[] arr, int low, int high, int num) {

		if(arr == null || arr.length == 0) {
			return -1;
		}

		if(low <= high) {

			int mid = (low + high) / 2;

			// if num found at mid, return mid
			if(num == arr[mid]) {
				return mid;
			}

			// if left array is sorted
			if(arr[low] <= arr[mid]) {

				// if num between the boundaries of left array, then recur on left array
				if(num >= arr[low] && num <= arr[mid]) {
					return search(arr, low, mid, num);
				}

				// else recur on right array
				return search(arr, mid + 1, high, num);
			}

			// left array is not sorted, right must be sorted
			// if num between boundaries of right array, then recur on right array
			if(num >= arr[mid + 1] && num <= arr[high]) {
				return search(arr, mid + 1, high, num);
			}

			// else recur on left array
			return search(arr, low, mid, num);
		}

		// element not found
		return -1;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchInSortedRotatedArray bSearch = new BinarySearchInSortedRotatedArray();

		int[] arr1 = {3, 4, 5, 1, 2};
		System.out.println(bSearch.search(arr1, 0, arr1.length - 1, 50));
		System.out.println(bSearch.search(arr1, 0, arr1.length - 1, 1));

		int[] arr2 = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		System.out.println(bSearch.search(arr2, 0, arr2.length - 1, 50));
		System.out.println(bSearch.search(arr2, 0, arr2.length - 1, 6));
		System.out.println(bSearch.search(arr2, 0, arr2.length - 1, 3));
	}
}
