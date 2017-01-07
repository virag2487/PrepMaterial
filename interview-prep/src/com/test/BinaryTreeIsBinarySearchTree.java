package com.test;

/**
 * Return true if binary tree is binary search tree, else false
 * 
 * Input:
 * 
 * 		  		 26
 *       		/   \
 *     		  10     30
 *   		/    \     \
 * 		   4      16    35
 * 
 * Output: True
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreeIsBinarySearchTree {

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
	Node prev;

	// ########### Method 1 ############

	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBST1(Node root) {
		return isBSTUtil1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean isBSTUtil1(Node root, int min, int max) {
		if(root == null) {
			return true;
		}

		if(root.data < min || root.data > max) {
			return false;
		}

		boolean lTree = isBSTUtil1(root.left, min, root.data - 1);
		boolean rTree = isBSTUtil1(root.right, root.data + 1, max);

		return lTree && rTree;
	}

	// ########### Method 2 ############

	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBST2(Node root) {
		prev = null;
		return isBSTUtil2(root);
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBSTUtil2(Node root) {
		if(root == null) {
			return true;
		}

		boolean lTree = isBSTUtil2(root.left);

		if(prev != null && root.data <= prev.data) {
			return false;
		}
		prev = root;

		boolean rTree = isBSTUtil2(root.right);

		return lTree && rTree;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeIsBinarySearchTree tree = new BinaryTreeIsBinarySearchTree();

		// Let us create the tree shown in above diagram
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(16);
		tree.root.right.right = new Node(35);

		// Tests for method 1
		System.out.println("Method 1: " + tree.isBST1(null));
		System.out.println("Method 1: " + tree.isBST1(new Node(1)));
		System.out.println("Method 1: " + tree.isBST1(tree.root));

		// Tests for method 2
		System.out.println("Method 2: " + tree.isBST2(null));
		System.out.println("Method 2: " + tree.isBST2(new Node(1)));
		System.out.println("Method 2: " + tree.isBST2(tree.root));

		/* 		  		  3
		 *       		/   \
		 *     		   2     5
		 *   		 /   \    
		 * 		    1     4    
		 */
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);

		// Tests for method 1
		System.out.println("Method 1: " + tree.isBST1(tree.root));

		// Tests for method 2
		System.out.println("Method 2: " + tree.isBST2(tree.root));
	}
}
