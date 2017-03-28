package com.test;

/**
 * Convert binary tree to max heap
 * 
 * Input:
 *						15                               
 *
 *				9				25
 *
 *			7		12    	20		30
 *
 * Output:
 *						30                               
 *
 *				12				25
 *
 *			7		9    	20		15
 *			
 * @author Virag Shah
 *
 */
public class BinarySearchTreeToMaxHeap {

	public static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node root;

	public void binarySearchTreeToMaxHeap(Node root) {

		if(root != null) {
			binarySearchTreeToMaxHeap(root.left);
			visit(root);
			binarySearchTreeToMaxHeap(root.right);

			if(root.right != null && root.data < root.right.data) {
				visit(root);
			}
		}
	}

	public void visit(Node node) {
		if(node.right != null) {

			int temp = node.data;
			node.data = node.right.data;
			node.right.data = temp;
		}
	}

	/**
	 * Input:
							15                               

					9				25

				7		12    	20		30
	 *
	 * Output:
							30                               

					12				25

				7		9    	20		15
	 */
	public static void main(String[] args) {
		BinarySearchTreeToMaxHeap bsToMh = new BinarySearchTreeToMaxHeap();

		bsToMh.root = new BinarySearchTreeToMaxHeap.Node(15);
		bsToMh.root.left = new BinarySearchTreeToMaxHeap.Node(9);
		bsToMh.root.right = new BinarySearchTreeToMaxHeap.Node(25);

		bsToMh.root.left.left = new BinarySearchTreeToMaxHeap.Node(7);
		bsToMh.root.left.right = new BinarySearchTreeToMaxHeap.Node(12);

		bsToMh.root.right.left = new BinarySearchTreeToMaxHeap.Node(20);
		bsToMh.root.right.right = new BinarySearchTreeToMaxHeap.Node(30);

		bsToMh.binarySearchTreeToMaxHeap(bsToMh.root);
		System.out.println("");
	}
}
