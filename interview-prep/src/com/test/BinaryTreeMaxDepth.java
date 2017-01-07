package com.test;

/**
 * Given a binary tree, find height of it. Height of empty tree is 0 and height of below tree is 3.
 * 
 * Input:
 * 							10
 * 						/		\
 * 					12			15
 * 					/	\	
 * 				25		30
 * 
 * Output: 3
 * 
 * @author Virag
 *
 */
public class BinaryTreeMaxDepth {

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

	public int maxDepth(Node root) {
		if(root == null) {
			return 0;
		}
		else {
			int lDepth = maxDepth(root.left);
			int rDepth = maxDepth(root.right);

			return (Math.max(lDepth, rDepth) + 1);
		}
	}

	public static void main(String[] args) {
		BinaryTreeMaxDepth tree = new BinaryTreeMaxDepth();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);

		System.out.println("Max depth: " + tree.maxDepth(tree.root));
	}

}
