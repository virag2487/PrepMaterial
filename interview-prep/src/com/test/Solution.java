package com.test;

import java.util.Scanner;
public class Solution {
	public static void main(String args[] ) throws Exception {

		Scanner scan = new Scanner(System.in);
		StringBuilder s = new StringBuilder();
		while(scan.hasNextLine()) {
			s.append(scan.nextLine());
		}

		System.out.println(s.toString());
	}
}
