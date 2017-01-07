package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
 * 
 * Input:
 * 
 * 		  		  5
 *       		/   \
 *     		   2     4
 *   		 /   \  
 * 		    1     3     
 * 
 * Output:
 * 		1
 * 		2
 * 		5 3
 * 		4
 * 
 * Input: 
 *      		 50
 *    		  /     \
 * 			30       60
 * 		  /    \    /   \ 
 *		 5     20  45    70
 *             			/  \
 *           		  65    80
 * Output:
 * 		5
 * 		30
 * 		50 20 45
 * 		60 65
 * 		70
 * 		80
 * 
 * HashMap based approach
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreePrintVerticalOrder2 {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	Node root;

	/**
	 * 
	 * @param root
	 */
	public void printVerticalOrder(Node root) {

		if(root == null) {
			return;
		}

		// map to store the node values at different horizontal distance from root
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		// populate the map
		getVerticalOrder(root, 0, map);

		// sort key in ascending order so that we can go from left to right
		List<Integer> keySet = new ArrayList<Integer>(map.keySet());
		Collections.sort(keySet);

		// iterate from left to right
		for(Integer key : keySet) {
			for(Integer value : map.get(key)) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param root
	 * @param horizontalDistance
	 * @param map
	 */
	public void getVerticalOrder(Node root, int horizontalDistance, Map<Integer, List<Integer>> map) {

		if(root == null) {
			return;
		}

		if(map.containsKey(horizontalDistance)) {
			map.get(horizontalDistance).add(root.data);
		}
		else {
			map.put(horizontalDistance, new ArrayList<Integer>(Arrays.asList(root.data)));
		}

		// recur over left subtree with horizontal distance - 1
		getVerticalOrder(root.left, horizontalDistance - 1, map);
		// recur over right subtree with horizontal distance + 1
		getVerticalOrder(root.right, horizontalDistance + 1, map);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreePrintVerticalOrder2 tree = new BinaryTreePrintVerticalOrder2();

		System.out.println("Vertical order is: ");
		tree.printVerticalOrder(null);

		System.out.println("Vertical order is: ");
		tree.printVerticalOrder(new Node(5));

		// Let us create the tree shown in above diagram
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println("Vertical order is: ");
		tree.printVerticalOrder(tree.root);

		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(20);
		tree.root.right.left = new Node(45);
		tree.root.right.right = new Node(70);
		tree.root.right.right.left = new Node(65);
		tree.root.right.right.right = new Node(80);

		System.out.println("Vertical order is: ");
		tree.printVerticalOrder(tree.root);
	}
}