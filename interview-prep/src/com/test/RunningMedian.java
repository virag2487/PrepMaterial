package com.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class RunningMedian {

	// minHeap
	PriorityQueue<Integer> upperQueue;
	// maxHeap
	PriorityQueue<Integer> lowerQueue;

	public RunningMedian() {
		// default ordering is ascending which is suitable for minHeap
		upperQueue = new PriorityQueue<Integer>();

		// adding comparator to order in descending order for maxHeap
		lowerQueue = new PriorityQueue<Integer>(20,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});

		upperQueue.add(Integer.MAX_VALUE);
		lowerQueue.add(Integer.MIN_VALUE);
	}

	public double getMedian(int num) {

		// add to either minHeap or maxHeap
		if(num >=  upperQueue.peek()) {
			upperQueue.add(num);
		}
		else {
			lowerQueue.add(num);
		}

		// balance the heaps
		if(upperQueue.size() - lowerQueue.size() == 2) {
			lowerQueue.add(upperQueue.poll());
		}
		else if(lowerQueue.size() - upperQueue.size() == 2) {
			upperQueue.add(lowerQueue.poll());
		}

		// return median
		if(upperQueue.size() == lowerQueue.size()) {
			return (upperQueue.peek() + lowerQueue.peek()) / 2.0;
		}
		else if(upperQueue.size() > lowerQueue.size()) {
			return upperQueue.peek();
		}
		else {
			return lowerQueue.peek();
		}
	}

	public static void main(String[] args) {
		RunningMedian rm = new RunningMedian();
		Random random = new Random();
		System.out.println("num\t\tmedian");

		for(int i = 0; i < 10; i++) {
			int num = random.nextInt(100);
			System.out.print(num);
			System.out.print("\t\t");
			System.out.println(rm.getMedian(num));
		}
	}
}
