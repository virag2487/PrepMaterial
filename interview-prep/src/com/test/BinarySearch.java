package com.test;

/**
 * Search an element in sorted array
 * 
 * @author Virag Shah
 *
 */
public class BinarySearch {

	/**
	 * 
	 * @param array
	 * @param x
	 * @return
	 */
	public int search(int[] array, int x) {

		if(array == null || array.length == 0) {
			return -1;
		}

		int low = 0;
		int high = array.length - 1;
		int middle;

		while(low <= high) {
			middle = (low + high) / 2;

			if(x < array[middle]) {
				high = middle - 1;
			}
			else if(x > array[middle]) {
				low = middle + 1;
			}
			else {
				return middle;
			}
		}

		// if not present
		return -1;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch bSearch = new BinarySearch();
		int[] array = {1, 2, 2, 3, 5, 9, 23, 67, 100, 199};

		System.out.println(bSearch.search(array, 50));
		System.out.println(bSearch.search(array, 23));
	}
}
