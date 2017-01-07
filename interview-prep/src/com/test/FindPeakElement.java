package com.test;

/**
 * Given an array of integers. Find a peak element in it. 
 * An array element is peak if it is NOT smaller than its neighbors. 
 * For corner elements, we need to consider only one neighbor. 
 * For example, for input array {5, 10, 20, 15}, 20 is the only peak element. 
 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. 
 * Note that we need to return any one peak element.
 * 
 * @author Virag
 *
 */
public class FindPeakElement {

	public int findPeak(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		while(low <= high) {
			int mid = (low + high) / 2;

			if((mid <= 0 || arr[mid] >= arr[mid - 1]) && (mid >= arr.length - 1 || arr[mid] >= arr[mid + 1])) {
				return mid;
			}
			else if(arr[mid] < arr[mid - 1]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		FindPeakElement peakElement = new FindPeakElement();
		int[] arr1 = {28, 2, 4, -1, 2, 3, 15, 3, 27};
		System.out.println("Index of peak element is: " + peakElement.findPeak(arr1));
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Index of peak element is: " + peakElement.findPeak(arr2));
		int[] arr3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("Index of peak element is: " + peakElement.findPeak(arr3));
	}
}