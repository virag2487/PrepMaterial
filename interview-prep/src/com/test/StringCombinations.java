package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
Input:
{
    "Country" : ["us", "ca", "mx"],
    "AgeRange" : ["0-9", "10-19", "20-29"],
    "Income" : ["low,"med","high"],
    "Gender" : ["male", "female"]
}

Output:
Country=us,AgeRange=0-9,Income=low,Gender=male
Country=ca,AgeRange=0-9,Income=low,Gender=male
Country=ca,AgeRange=10-19,Income=low,Gender=male
 */

public class StringCombinations {

	public void printCombinations(Map<String, List<String>> userData) {

		Iterator<Map.Entry<String, List<String>>> it = userData.entrySet().iterator();
		print("", it, (Map.Entry<String, List<String>>) it.next());
	}


	public static void print(String output, Iterator<Map.Entry<String, List<String>>> it, Map.Entry<String, List<String>> entry) {

		if(entry == null) {
			System.out.println(output);
			return;
		}

		List<String> list = entry.getValue();

		Map.Entry<String, List<String>> ent = it.hasNext() ? it.next() : null;

		for(String s : list) {
			print((output + entry.getKey() + "=" + s + " "), it, ent);
		}
	}

	public static void main(String[] args) {
		StringCombinations sc = new StringCombinations();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> l1 = Arrays.asList(new String[]{"us","ca", "mx"});
		List<String> l2 = Arrays.asList(new String[]{"0-9","10-19", "20-29"});
		List<String> l3 = Arrays.asList(new String[]{"low","med","high"});
		List<String> l4 = Arrays.asList(new String[]{"male","female"});

		map.put("country", l1);
		map.put("ageRange", l2);
		map.put("income", l3);
		map.put("gender", l4);

		sc.printCombinations(map);
	}
}
