package com.test;

import java.util.Arrays;

public class MergeSort {

	int[] numbers;
	int[] helper;
	int length;

	/**
	 * 
	 * @param array
	 */
	public void sort(int[] array) {
		numbers = array;
		length = numbers.length;
		helper = new int[length];
		mergeSort(0, length - 1);
	}

	/**
	 * 
	 * @param low
	 * @param high
	 */
	public void mergeSort(int low, int high) {

		if(low < high) {
			int middle = (low + high) / 2;
			// sort left array
			mergeSort(low, middle);
			// sort right array
			mergeSort(middle + 1, high);
			// merge the arrays
			merge(low, middle, high);
		}
	}

	/**
	 * 
	 * @param low
	 * @param middle
	 * @param high
	 */
	public void merge(int low, int middle, int high) {
		// copy entire array to helper array
		for(int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while(helperLeft <= middle && helperRight <= high) {
			if(helper[helperLeft] <= helper[helperRight]) {
				numbers[current] = helper[helperLeft];
				helperLeft++;
			}
			else {
				numbers[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		while(helperLeft <= middle) {
			numbers[current] = helper[helperLeft];
			helperLeft++;
			current++;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] array = {3, 2, 9, 23, 67, 2, 1, 199, 100, 5};

		mergeSort.sort(array);

		System.out.println(Arrays.toString(array));
	}
}
