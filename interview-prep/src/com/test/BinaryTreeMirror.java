package com.test;

/**
 * Find mirror of a binary tree
 * 
 * Input:
 * 							10
 * 						/		\
 * 					12				15
 * 					/	\			/
 * 				25		30		22
 * 
 * Output: 
 * 							10
 * 						/		\
 * 					15				12
 * 						\			/	\	
 * 						22		30		25
 * 
 * @author Virag
 *
 */
public class BinaryTreeMirror {

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

	public Node mirror(Node root) {
		if(root == null) {
			return root;
		}

		Node left = mirror(root.left);
		Node right = mirror(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	public void inOrder(Node root) {
		if(root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		BinaryTreeMirror tree = new BinaryTreeMirror();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(22);

		System.out.print("Original: ");
		tree.inOrder(tree.root);
		System.out.println("");

		Node mirror = tree.mirror(tree.root);

		System.out.print("Mirror: ");
		tree.inOrder(mirror);
		System.out.println("");

	}
}