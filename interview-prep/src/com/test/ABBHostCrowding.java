package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 Host Crowding

You are given an array of csv strings indicating search results.
Each has a host_id, listing_id, score, and city.  Initially, results
are sorted by highest score.

We’d like to display these search results on a web page.  Write a function
that returns groups of listings to be displayed on each page.  However,
note that a given host may have several listings that show up in the results.
Reorder the list so that a host shows up at most once on a page *if possible*,
but otherwise preserves the ordering.

Your program should return the new array and print out the results in
blocks representing the pages.


Input:
 *  An array of csv strings, with sort score
 *  number of results per page

 */

public class ABBHostCrowding {

	/**
	 * 
	 * @param input
	 * @param perPage
	 * @return
	 */
	public List<List<String>> displayResults(List<String> input, int perPage) {

		List<Integer> visitedHosts = new ArrayList<Integer>();
		List<List<String>> output = new ArrayList<List<String>>();
		List<String> perPageList = new ArrayList<String>();
		List<String> skippedEntries = new ArrayList<String>();

		for(String str : input) {
			if(str.equals("host_id,listing_id,score,city")) {
				continue; 
			}

			String[] array = str.split(",");


			if(!visitedHosts.contains(Integer.parseInt(array[0])) && perPageList.size() < 12) {
				visitedHosts.add(Integer.parseInt(array[0]));
				perPageList.add(str);
			}

			else {
				if(visitedHosts.contains(Integer.parseInt(array[0]))) {
					skippedEntries.add(str);
				}

				if(perPageList.size() == 12) {
					output.add(perPageList);
					perPageList = new ArrayList<String>();
					visitedHosts = new ArrayList<Integer>();

					Iterator<String> iterator = skippedEntries.iterator();

					while(iterator.hasNext()) {
						String s = iterator.next();
						String[] array1 = s.split(",");
						if(!visitedHosts.contains(Integer.parseInt(array1[0]))) {
							visitedHosts.add(Integer.parseInt(array1[0]));
							perPageList.add(s);
							iterator.remove();
						}
					}

					perPageList.add(str);
					visitedHosts.add(Integer.parseInt(array[0]));
				}
			}
		}

		perPageList.addAll(skippedEntries);
		output.add(perPageList);
		return output;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args) {

		ABBHostCrowding abb = new ABBHostCrowding();

		int PER_PAGE = 12;

		ArrayList<String> input = new ArrayList<String>();
		input.add("host_id,listing_id,score,city");
		input.add("1,28,300.1,San Francisco");
		input.add("4,5,209.1,San Francisco");
		input.add("20,7,208.1,San Francisco");
		input.add("23,8,207.1,San Francisco");
		input.add("16,10,206.1,Oakland");
		input.add("1,16,205.1,San Francisco");
		input.add("6,29,204.1,San Francisco");
		input.add("7,20,203.1,San Francisco");
		input.add("8,21,202.1,San Francisco");
		input.add("2,18,201.1,San Francisco");
		input.add("2,30,200.1,San Francisco");
		input.add("15,27,109.1,Oakland");
		input.add("10,13,108.1,Oakland");
		input.add("11,26,107.1,Oakland");
		input.add("12,9,106.1,Oakland");
		input.add("13,1,105.1,Oakland");
		input.add("22,17,104.1,Oakland");
		input.add("1,2,103.1,Oakland");
		input.add("28,24,102.1,Oakland");
		input.add("18,14,11.1,San Jose");
		input.add("6,25,10.1,Oakland");
		input.add("19,15,9.1,San Jose");
		input.add("3,19,8.1,San Jose");
		input.add("3,11,7.1,Oakland");
		input.add("27,12,6.1,Oakland");
		input.add("1,3,5.1,Oakland");
		input.add("25,4,4.1,San Jose");
		input.add("5,6,3.1,San Jose");
		input.add("29,22,2.1,San Jose");
		input.add("30,23,1.1,San Jose");

		List<List<String>> results = abb.displayResults(input, PER_PAGE);

		int i = 1;

		for(List<String> list : results) {
			System.out.println("Page " + i++);
			for(String s : list) {
				System.out.println(s); 
			}
		}
	}
}