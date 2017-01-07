package com.test;

/**
 * Given a Binary Tree where each node has positive and negative values. 
 * Convert this to a tree where each node contains the sum of the left and 
 * right sub trees in the original tree. The values of leaf nodes are changed to 0. 
 * 
 * For example, the following tree
 * 
 * Input: 
 * 
 * 				  10
 *              /      \
 *	     	 -2        6
 *          /   \      /  \ 
 *	 	  8     -4    7    5
 *
 * Output: 
 *
 *				20(4-2+12+6)
 *              /     	 \
 *	  		 4(8-4)      12(7+5)
 *           /     \      /     \ 
 *	 		0       0    0       0
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreeConversionToSumTree {

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
	public int toSumTree(Node root) {
		if(root == null) {
			return 0;
		}

		// need to preserve current value of node before resetting it to lTree + rTree
		int currentRootValue = root.data;

		int lTree = toSumTree(root.left);
		int rTree = toSumTree(root.right);

		root.data = lTree + rTree;

		return root.data + currentRootValue;
	}

	/**
	 * 
	 * @param node
	 */
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeConversionToSumTree tree = new BinaryTreeConversionToSumTree();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(-4);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(5);

		tree.toSumTree(tree.root);
		tree.inOrder(tree.root);

		tree.root.right.right = new Node(5);
	}
}
