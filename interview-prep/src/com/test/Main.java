package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		HDTV tv = new HDTV(55, "Sam");
		HDTV tv1 = new HDTV(55, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
		HDTV tv3 = new HDTV(42, "Panasonic");

		TreeSet<HDTV> set = new TreeSet<HDTV>();
		set.add(tv);
		set.add(tv1);
		System.out.println(set.size());

		for (HDTV a : set) {
			System.out.println(a.getBrand());
		}

		ArrayList<HDTV> al = new ArrayList<HDTV>();
		al.add(tv1);
		al.add(tv2);
		al.add(tv3);

		System.out.println("Comparable output:");

		// Uses Comparable interface's compareTo method
		Collections.sort(al);
		for (HDTV a : al) {
			System.out.println(a.getBrand());
		}

		System.out.println("Comparator output:");

		// Uses Comparator interface's compare method
		Collections.sort(al, new SizeComparator());
		for (HDTV a : al) {
			System.out.println(a.getBrand());
		}
	}
}