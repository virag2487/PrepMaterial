package com.test;

import java.util.Scanner;

public class MaxContiguousSumMaxNonContiguousSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int[] arr = new int[n];

			scan.nextLine();

			String num = scan.nextLine();
			String[] s = num.split(" ");
			for(int j = 0; j < s.length; j++) {
				arr[j] = Integer.parseInt(s[j]);
			}

			// Max contiguous sum
			int cSum = arr[0];
			int tempSum = arr[0];
			for(int j = 1; j < n; j++) {
				tempSum = Math.max(tempSum + arr[j], arr[j]);
				cSum = Math.max(cSum, tempSum);
			}

			// Max non-contiguous sum (non necessarily contiguous)
			int nonCSum = arr[0];
			tempSum = 0;
			for(int j = 0; j < n; j++) {
				if(arr[j] > 0) {
					tempSum += arr[j];
				}
				nonCSum = Math.max(nonCSum, arr[j]);
			}

			if(tempSum != 0) {
				nonCSum = tempSum;
			}

			System.out.println("" + cSum + " " + nonCSum);
		}
		scan.close();
	}
}
