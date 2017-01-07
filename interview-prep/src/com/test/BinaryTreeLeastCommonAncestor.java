package com.test;

/**
 * Find Least Common Ancestor (LCA) of two nodes
 * 
 * Input:
 * 							10
 * 						/		\
 * 					12				15
 * 					/	\			/
 * 				25		30		22
 * 
 * Output: LCA of 12, 15 = 10
 * 		   LCA of 25, 30 = 12
 * 		   LCA of 25, 22 = 10
 * 		   LCA of 12, 25 = 12
 * 		   LCA of 10, 22 = 10
 * 
 * @author Virag
 *
 */
public class BinaryTreeLeastCommonAncestor {

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

	public int findLCA(Node root, int a, int b) {
		if(root == null) {
			return -1;
		}

		// if at least one matched, no need to continue
		// this is the LCA for this root
		if(root.data == a || root.data == b) {
			return root.data;
		}

		int l = findLCA(root.left, a, b);
		int r = findLCA(root.right, a, b);

		// nodes are each on a seaparate branch
		if(l != -1 && r != -1) {
			return root.data;
		}

		// either one node is on one branch, 
		// or none was found in any of the branches
		return l != -1 ? l : r;
	}

	public static void main(String[] args) {
		BinaryTreeLeastCommonAncestor tree = new BinaryTreeLeastCommonAncestor();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(22);

		System.out.println("LCA of 12 and 15: " + tree.findLCA(tree.root, 12, 15));
		System.out.println("LCA of 25 and 30: " + tree.findLCA(tree.root, 25, 30));
		System.out.println("LCA of 25 and 22: " + tree.findLCA(tree.root, 25, 22));
		System.out.println("LCA of 12 and 25: " + tree.findLCA(tree.root, 12, 25));
		System.out.println("LCA of 10 and 22: " + tree.findLCA(tree.root, 10, 22));
	}
}
