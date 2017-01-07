package com.test;

/**
 * Find size of binary tree
 * 
 * Input:
 * 
 * 		  		 26
 *       		/   \
 *     		  10     3
 *   		/    \     \
 * 		   4      6      3
 * 
 * Output: 6
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreeSize {

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
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeSize tree = new BinaryTreeSize();

		// Let us create the tree shown in above diagram
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(3);

		System.out.println(tree.sizeOfTree(null));
		System.out.println(tree.sizeOfTree(new Node(1)));
		System.out.println(tree.sizeOfTree(tree.root));
	}
}
