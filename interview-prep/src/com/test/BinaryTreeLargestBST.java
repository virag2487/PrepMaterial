package com.test;

/**
 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). 
 * If the complete Binary Tree is BST, then return the size of whole tree.
 * 
 * Input:
 * 
 * 		  		  5
 *       		/   \
 *     		   2     4
 *   		 /   \  
 * 		    1     3     
 * 
 * Output: 3
 * The following subtree is the maximum size BST subtree 
 *  			2  
 * 	  		   /  \
 * 	 		  1    3
 * 
 * Input: 
 *      		 50
 *    		  /     \
 * 			30       60
 * 		   /  \     /   \ 
 *		  5   20   45    70
 *             			/  \
 *           		  65    80
 * Output: 5
 * The following subtree is the maximum size BST subtree 
 *    			60
 *    		   /  \ 
 *  		 45    70
 *       		  /  \
 *     			65    80
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreeLargestBST {

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
	 * @return
	 */
	public boolean isBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean isBSTUtil(Node root, int min, int max) {
		if(root == null) {
			return true;
		}

		if(root.data < min || root.data > max) {
			return false;
		}

		boolean lTree = isBSTUtil(root.left, min, root.data - 1);
		boolean rTree = isBSTUtil(root.right, root.data + 1, max);

		return lTree && rTree;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public int sizeOfTree(Node root) {
		if(root == null) {
			return 0;
		}

		int lTree = sizeOfTree(root.left);
		int rTree = sizeOfTree(root.right);

		return lTree + 1 + rTree;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public int largestBST(Node root) {
		if(isBST(root)) {
			return sizeOfTree(root);
		}

		int lTree = largestBST(root.left);
		int rTree = largestBST(root.right);

		return Math.max(lTree, rTree);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeLargestBST tree = new BinaryTreeLargestBST();

		// Let us create the tree shown in above diagram
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println(tree.largestBST(tree.root));

		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(20);
		tree.root.right.left = new Node(45);
		tree.root.right.right = new Node(70);
		tree.root.right.right.left = new Node(65);
		tree.root.right.right.right = new Node(80);

		System.out.println(tree.largestBST(tree.root));
	}
}
