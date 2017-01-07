package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method that takes a String an input and reverses just the vowels in each word of the string.
 * 
 * Eg: Salesforce is a company
 * returns: Selosferca is a campony 
 * 
 * @author Virag Shah
 *
 */
public class ReverseVowels {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public String reverseVowels(String input) {

		if(input == null || input.length() == 0) {
			return input; 
		}

		List<Character> vowelList = new ArrayList<Character>();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		vowelList.add('A');
		vowelList.add('E');
		vowelList.add('I');
		vowelList.add('O');
		vowelList.add('U');

		String[] splitInput = input.split(" ");
		StringBuilder builder = new StringBuilder();

		for(String s : splitInput) {

			char[] array = s.toCharArray();

			int i = 0;
			int j = s.length() - 1;

			while(i < j) {

				if(!vowelList.contains(array[i])) {
					i++;
					continue;
				}

				if(!vowelList.contains(array[j])) {
					j--;
					continue;
				}

				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;

				i++;
				j--;
			}

			builder.append(new String(array)).append(" ");
		}

		return builder.toString();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseVowels soln = new ReverseVowels();

		System.out.println(soln.reverseVowels("Salesforce is a company"));
		System.out.println(soln.reverseVowels("Alchemist"));
	}
}