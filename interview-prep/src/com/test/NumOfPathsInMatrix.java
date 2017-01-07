package com.test;

/**
 * 
 * @author Virag Shah
 *
 */
public class NumOfPathsInMatrix {

	private int[][] cache;

	public int numberOfPathsHelp(int[][] a, int i, int j) {

		if(i > a.length - 1 || j > a[0].length - 1) {
			return 0;
		}

		if(cache[i][j] != -1) {
			return cache[i][j];
		}

		if(a[i][j] == 0) {
			return 0;
		}

		if(i == a.length - 1 && j == a[0].length - 1) {
			return 1;
		}

		cache[i][j] = numberOfPathsHelp(a, i + 1, j) + numberOfPathsHelp(a, i, j + 1);
		return cache[i][j];
	}


	public int numberOfPaths(int[][] a) {
		cache = new int[a.length][a[0].length];

		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				cache[i][j] = -1;
			}
		}
		return (numberOfPathsHelp(a, 0, 0) % 1000000007);
	}

	public static void main(String[] args) {
		NumOfPathsInMatrix matrix = new NumOfPathsInMatrix();

		int[][] a1 = new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
		System.out.println(matrix.numberOfPaths(a1));

		int[][] a2 = new int[][] {{1, 1}, {0, 1}};
		System.out.println(matrix.numberOfPaths(a2));

		int[][] a3 = new int[][] {
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 0, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1}};
			System.out.println(matrix.numberOfPaths(a3));
	}
}