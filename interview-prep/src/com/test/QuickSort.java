package com.test;

import java.util.Arrays;

public class QuickSort {

	int[] numbers;
	int length;

	/**
	 * 
	 * @param array
	 */
	public void sort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		numbers = array;
		length = numbers.length;
		quickSort(0, length - 1);
	}

	/**
	 * 
	 * @param low
	 * @param high
	 */
	public void quickSort(int low, int high) {
		int i = low;
		int j = high;

		int pivot = numbers[(low + high) / 2];

		// divide into 2 arrays
		while(i <= j) {

			while(numbers[i] < pivot) {
				i++;
			}

			while(numbers[j] > pivot) {
				j--;
			}

			if(i <= j) {
				swap(i, j);
				i++;
				j--;
			}

			if(low < j) {
				quickSort(low, j);
			}
			if(i < high) {
				quickSort(i, high);
			}
		}
	}

	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] array = {3, 2, 9, 23, 67, 2, 1, 199, 100, 5};

		quickSort.sort(array);

		System.out.println(Arrays.toString(array));
	}

}
