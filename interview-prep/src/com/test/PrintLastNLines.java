package com.test;

/**
 * Given some text lines in one string, each line is separated by ‘\n’ character. Print the last 'n' lines. 
 * If number of lines is less than 'n', then print all lines.
 * 
 * @author Virag Shah
 *
 */
public class PrintLastNLines {

	/**
	 * 
	 * @param line
	 * @param n
	 */
	public void printLines(String line, int n) {

		if(line == null || line.length() == 0) {
			System.out.println("ERROR: Input is empty");
			return;
		}

		String[] splitLine = line.split("\n");

		if(splitLine == null || splitLine.length == 0) {
			System.out.println("ERROR: Input is empty");
			return;
		}

		if(splitLine.length <= n) {
			System.out.println("Printing last " + n + " lines:");
			System.out.println(line);
			return;
		}

		System.out.println("Printing last " + n + " lines:");
		for(int i = splitLine.length - n; i < splitLine.length; i++) {
			System.out.println(splitLine[i]);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PrintLastNLines lines = new PrintLastNLines();

		String line1 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7\nstr8\nstr9\nstr10\n"
				+ "str11\nstr12\nstr13\nstr14\nstr15\nstr16\nstr17\nstr18\nstr19\nstr20\n"
				+ "str21\nstr22\nstr23\nstr24\nstr25";

		String line2 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7";

		String line3 = "\n";

		String line4 = "";

		lines.printLines(line1, 10);
		lines.printLines(line2, 10);
		lines.printLines(line3, 10);
		lines.printLines(line4, 10);
	}
}
