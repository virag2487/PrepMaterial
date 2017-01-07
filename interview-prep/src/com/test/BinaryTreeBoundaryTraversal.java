package com.test;

/**
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 * 
 * Input:
 * 
 * 		  		  5
 *       		/   \
 *     		   2     4
 *   		 /   \  
 * 		    1     3     
 * 
 * Output: 5 2 1 3 4
 * 
 * Input: 
 *      		 50
 *    		  /     \
 * 			30       60
 * 		  /    \    /   \ 
 *		 5     20  45    70
 *            / 		/  \
 *           10		  65    80
 *           
 * Output: 50 30 5 10 45 65 80 70 60
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreeBoundaryTraversal {

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
	public void boundaryTraversal(Node root) {
		if(root == null) {
			return;
		}

		// print root
		System.out.print(root.data + " ");

		// print left boundary from top to bottom
		printLeftBoundary(root.left);
		// print leaves
		printLeaves(root.left);
		printLeaves(root.right);
		// print right boundary from bottom to top
		printRightBoundary(root.right);

		System.out.println();
	}

	/**
	 * 
	 * @param node
	 */
	public void printLeftBoundary(Node node) {
		if(node == null || (node.left == null && node.right == null)) {
			return;
		}

		System.out.print(node.data + " ");
		printLeftBoundary(node.left);
	}

	/**
	 * 
	 * @param node
	 */
	public void printRightBoundary(Node node) {
		if(node == null || (node.left == null && node.right == null)) {
			return;
		}

		printRightBoundary(node.right);
		System.out.print(node.data + " ");
	}

	/**
	 * 
	 * @param node
	 */
	public void printLeaves(Node node) {
		if(node == null) {
			return;
		}

		printLeaves(node.left);

		if(node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}

		printLeaves(node.right);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeBoundaryTraversal tree = new BinaryTreeBoundaryTraversal();

		System.out.println("Boundary traversal: ");
		tree.boundaryTraversal(null);

		System.out.println("Boundary traversal: ");
		tree.boundaryTraversal(new Node(5));

		// Let us create the tree shown in above diagram
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println("Boundary traversal: ");
		tree.boundaryTraversal(tree.root);

		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(20);
		tree.root.left.right.left = new Node(10);
		tree.root.right.left = new Node(45);
		tree.root.right.right = new Node(70);
		tree.root.right.right.left = new Node(65);
		tree.root.right.right.right = new Node(80);

		System.out.println("Boundary traversal: ");
		tree.boundaryTraversal(tree.root);
	}
}