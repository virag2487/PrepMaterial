package com.test;

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
 * @author Virag Shah
 *
 */
public class BinaryTreePrintVerticalOrder {

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
	int MIN;
	int MAX;

	/**
	 * 
	 * @param root
	 */
	public void verticalOrder(Node root) {
		if(root == null) {
			return;
		}

		// find minimum distance (left side) and maximum distance (right side) from root
		findMinMax(root, 0);

		// iterate from left (min) to right (max)
		for(int lineNo = MIN; lineNo <= MAX; lineNo++) {
			// print from left to right
			printVerticalOrder(root, lineNo, 0);
			System.out.println("");
		}
	}

	/**
	 * 
	 * @param root
	 * @param horizontalDistance
	 */
	public void findMinMax(Node root, int horizontalDistance) {
		if(root == null) {
			return;
		}

		if(horizontalDistance < MIN) {
			MIN = horizontalDistance;
		}
		else if(horizontalDistance > MAX) {
			MAX = horizontalDistance;
		}

		// recur over left subtree with horizontal distance - 1
		findMinMax(root.left, horizontalDistance - 1);
		// recur over right subtree with horizontal distance + 1
		findMinMax(root.right, horizontalDistance + 1);
	}

	/**
	 * 
	 * @param root
	 * @param lineNo
	 * @param horizontalDistance
	 */
	public void printVerticalOrder(Node root, int lineNo, int horizontalDistance) {
		if(root == null) {
			return;
		}

		// when horizontal distance from root is equal to lineNo to be printed, print the data
		if(horizontalDistance == lineNo) {
			System.out.print(root.data + " ");
		}

		// recur over left subtree with horizontal distance - 1
		printVerticalOrder(root.left, lineNo, horizontalDistance - 1);
		// recur over right subtree with horizontal distance + 1
		printVerticalOrder(root.right, lineNo, horizontalDistance + 1);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreePrintVerticalOrder tree = new BinaryTreePrintVerticalOrder();

		System.out.println("Vertical order is: ");
		tree.verticalOrder(null);

		System.out.println("Vertical order is: ");
		tree.verticalOrder(new Node(5));

		// Let us create the tree shown in above diagram
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println("Vertical order is: ");
		tree.verticalOrder(tree.root);

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
		tree.verticalOrder(tree.root);
	}
}
