package com.test;

/**
 * Write a function that returns true if the given Binary Tree is SumTree else false. 
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes 
 * present in its left subtree and right subtree. An empty tree is SumTree and sum of 
 * an empty tree can be considered as 0. A leaf node is also considered as SumTree. 
 * 
 * Following is an example of SumTree.
 * 
 * 		  		 26
 *       		/   \
 *     		  10     3
 *   		/    \     \
 * 		   4      6      3
 * 
 * 
 * @author Virag Shah
 *
 */
public class BinaryTreeIsSumTree {

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
	 * @param node
	 * @return
	 */
	public int sum(Node node) {
		if(node == null) {
			return 0;
		}

		return sum(node.left) + node.data + sum(node.right);
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSumTree(Node root) {
		if(root == null || (root.left == null && root.right == null)) {
			return true;
		}

		int lSum = sum(root.left);
		int rSum = sum(root.right);

		boolean lTree = isSumTree(root.left);
		boolean rTree = isSumTree(root.right);

		// sum of current should be equal to left + right and both left and right subtree should be sum tree
		if(root.data == (lSum + rSum) && lTree && rTree) {
			return true;
		}

		return false;
	}

	public void print(boolean isSumTree) {
		if(isSumTree) {
			System.out.println("The given binary tree is a sum tree");
		}
		else {
			System.out.println("The given binary tree is not a sum tree");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeIsSumTree tree = new BinaryTreeIsSumTree();

		// Let us create the tree shown in above diagram
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(3);

		boolean isSumTree = tree.isSumTree(null);
		tree.print(isSumTree);

		isSumTree = tree.isSumTree(new Node(25));
		tree.print(isSumTree);

		isSumTree = tree.isSumTree(tree.root);
		tree.print(isSumTree);

		tree.root.right.right = null;
		isSumTree = tree.isSumTree(tree.root);
		tree.print(isSumTree);
	}
}