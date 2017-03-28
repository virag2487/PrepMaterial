package com.test;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Implement a Min Stack， which supports peekMin() and popMin()
 * 
 * @author Virag Shah
 *
 * @param <T>
 */
public class MinStack<T> {

	LinkedList<T> stack;
	PriorityQueue<T> minHeap;

	public MinStack() {
		stack = new LinkedList<T>();
		minHeap = new PriorityQueue<T>(10);
	}

	/**
	 * 
	 * @param n
	 */
	public void push(T n) {
		stack.addLast(n);
		minHeap.offer(n);
	}

	/**
	 * 
	 * @return
	 */
	public T pop() {
		T num = stack.removeLast();
		minHeap.remove(num);
		return num;
	}

	/**
	 * 
	 * @return
	 */
	public T top() {
		return stack.peekLast();
	}

	/**
	 * 
	 * @return
	 */
	public T peekMin() {
		return minHeap.peek();
	}

	/**
	 * 
	 * @return
	 */
	public T popMin() {
		T num = minHeap.poll();
		stack.remove(num);
		return num;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack<Integer> stack = new MinStack<Integer>();
		int[] arr = {3, 1, 2, 4, 6, 5};
		for (Integer n: arr) {
			stack.push(n);
		}
		System.out.println(stack.popMin());  // 1
		System.out.println(stack.popMin());  // 2
		System.out.println(stack.popMin());  // 3
		System.out.println(stack.pop());     // 5
		System.out.println(stack.popMin());  // 4
	}
}