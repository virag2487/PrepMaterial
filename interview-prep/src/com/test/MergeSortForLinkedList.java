package com.test;

/**
 * Given a Linked List, Sort it using merge sort.
 * 
 * Input: ->9->3->4->2->5->1
 * Output: ->1->2->3->4->5->9
 * 
 * @author Virag Shah
 *
 */
public class MergeSortForLinkedList {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * 
	 * @param head
	 * @return
	 */
	public Node mergeSort(Node head) {

		// divide list into 2
		// head1 points to input head
		Node head1 = head;

		// if only 1 element in list, return the list as it is sorted
		if(head.next == null) {
			return head;
		}

		// find midpoint to list
		int mid = getLength(head) / 2;

		// iterate to mid of list
		while(mid - 1 != 0) {
			head1 = head1.next;
			mid--;
		}

		// head 2 would be next to mid
		Node head2 = head1.next;

		// separate the linkedlist into 2
		head1.next = null;

		// get head1 back to start of list
		// so head1 has values from start to mid and head2 has values from mid + 1 to end
		head1 = head;

		// repeat this for both the lists
		Node n1 = mergeSort(head1);
		Node n2 = mergeSort(head2);

		// merge the list
		return mergeList(n1, n2);
	}

	/**
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public Node mergeList(Node n1, Node n2) {

		Node result;

		if(n1 == null) {
			return n2;
		}
		if(n2 == null) {
			return n1;
		}

		// merging in ascending order
		if(n1.data > n2.data) {
			result = n2;
			result.next = mergeList(n1, n2.next);
		}
		else {
			result = n1;
			result.next = mergeList(n1.next, n2);
		}

		return result;
	}

	/**
	 * 
	 * @param head
	 * @return
	 */
	public int getLength(Node head) {
		if(head == null) {
			return 0;
		}

		int count = 0;

		while(head != null) {
			count++;
			head = head.next;
		}

		return count;
	}

	/**
	 * 
	 * @param head
	 */
	public void print(Node head) {
		if(head == null) {
			return;
		}

		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSortForLinkedList linkedList = new MergeSortForLinkedList();

		Node head = new Node(9);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(1);

		// print before sorting
		linkedList.print(head);
		Node result = linkedList.mergeSort(head);
		// print after sorting
		linkedList.print(result);
	}
}
