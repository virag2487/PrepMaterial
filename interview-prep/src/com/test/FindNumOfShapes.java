package com.test;

/**
 * Given a matrix of 0's and 1's find the number of groups of 1's in the matrix. 
 * A group of 1's can be formed if a 1 is present either vertically or horizontally 
 * to the adjacent 1 and not diagonally. 
 * 
 * 		1 0 0 0 
 * 		1 1 0 0 
 * 		0 0 1 1 
 * 		0 0 1 1 
 * 
 * The above matrix has two groups of 1's while the one shown here has only one group 
 * 
 * 		1 1 0 0
 * 		1 1 1 0 
 * 		1 1 0 0 
 * 
 * @author Virag Shah
 *
 */
public class FindNumOfShapes {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public int numOfShapes(int[][] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int numOfShapes = 0;
		int row = array.length;
		int col = array[0].length;

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(array[i][j] == 1) {

					numOfShapes++;
					doFill(array, i, j);
				}
			}
		}

		return numOfShapes;
	}

	/**
	 * 
	 * @param array
	 * @param row
	 * @param col
	 */
	public void doFill(int[][] array, int row, int col) {
		if(row < 0 || col < 0 || row >= array.length || col >= array[0].length || array[row][col] == 0) {
			return;
		}

		array[row][col] = 0;
		doFill(array, row + 1, col);
		doFill(array, row, col + 1);
		doFill(array, row - 1, col);
		doFill(array, row, col - 1);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumOfShapes shapes = new FindNumOfShapes();

		// 1001
		// 1001
		// 1111 return 1
		int[][] input1 = new int[][] {{1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}}; 
		System.out.println(shapes.numOfShapes(input1));

		// 11
		// 11 return 1
		int[][] input2 = new int[][] {{1, 1}, {1, 1}}; 
		System.out.println(shapes.numOfShapes(input2));

		// 1001
		// 0000
		// 1001 return 4
		int[][] input3 = new int[][] {{1, 0, 0, 1}, {0, 0, 0, 0}, {1, 0, 0, 1}}; 
		System.out.println(shapes.numOfShapes(input3));
	}
}
