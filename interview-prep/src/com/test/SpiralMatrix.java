package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Print matrix in spiral order
 * 
 * Input: 
 * 			1, 2, 3
 * 			4, 5, 6
 * 			7, 8, 9
 * 
 * Output: 1, 2, 3, 6, 9, 8, 7, 4, 5
 * 
 * Input: 
 * 			1,  2,  3,  4,  5
 * 			6,  7,  8,  9,  10
 * 			11, 12, 13, 14, 15
 * 
 * Output: 1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9
 * 
 * @author Virag
 *
 */
public class SpiralMatrix {

	/**
	 * 
	 * @param matrix
	 * @param row
	 * @param col
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix, int row, int col) {
		List<Integer> output = new ArrayList<Integer>();

		int left = 0;
		int right = col - 1;
		int top = 0;
		int bottom = row - 1;
		while(output.size() < row * col) {
			for(int i = left; i <= right; i++) {
				output.add(matrix[top][i]);
			}
			top++;

			for(int j = top; j <= bottom; j++) {
				output.add(matrix[j][right]);
			}
			right--;

			if(bottom < top) {
				break;
			}

			for(int i = right; i >= left; i--) {
				output.add(matrix[bottom][i]);
			}
			bottom--;

			if(right < left) {
				break;
			}

			for(int j = bottom; j >= top; j--) {
				output.add(matrix[j][left]);
			}
			left++;
		}

		return output;
	}

	/**
	 * 
	 * @param list
	 */
	public void print(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			if(i > 0) {
				System.out.print(",");
			}
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	public static void main(String args[] ) throws Exception {
		SpiralMatrix spiralMatrix = new SpiralMatrix();

		int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> output = spiralMatrix.spiralOrder(matrix1, matrix1.length, matrix1[0].length);
		spiralMatrix.print(output);

		int[][] matrix2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
		output = spiralMatrix.spiralOrder(matrix2, matrix2.length, matrix2[0].length);
		spiralMatrix.print(output);
	}
}