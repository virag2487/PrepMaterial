package com.test;

// Given an array where difference between adjacent elements is 1, 
// write an algorithm to search for an element in the array and 
// return the position of the element (return the first occurrence).

// arr = {-1, 0, 1, 2, 1, 2, 3, 4, 3}
// Find 4 --> index 7
// Find 1 --> index 2
// Find 2 --> index 3
// Find 5 --> return -1
public class FindNumInAnArray {

	public int findNum(int[] arr, int num) {

		int size = arr.length;
		int i = 0;
		while(i < size) {

			if(arr[i] == num) {
				return i;
			}

			i += Math.abs((arr[i] - num));
		}

		return -1;
	}

	public static void main(String[] args) {
		FindNumInAnArray find = new FindNumInAnArray();
		int arr[] = {-1, 0, 1, 2, 1, 2, 3, 4, 3};

		System.out.println("Element 4 is present at index " + find.findNum(arr, 4));
		System.out.println("Element 1 is present at index " + find.findNum(arr, 1));
		System.out.println("Element 2 is present at index " + find.findNum(arr, 2));
		System.out.println("Element 5 is present at index " + find.findNum(arr, 5));
	}
}