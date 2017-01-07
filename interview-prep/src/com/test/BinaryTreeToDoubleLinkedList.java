package com.test;

/**
 * Convert a given Binary Tree to Doubly Linked List
 * 
 * Input:
 * 							10
 * 						/		\
 * 					12				15
 * 					/	\			/
 * 				25		30		36
 * 
 * Output:
 * 				25<->12<->30<->10<->36<->15
 * 
 * @author Virag
 *
 */
public class BinaryTreeToDoubleLinkedList {

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

	public Node binaryTreeToDoubleLinkedList(Node root) {
		if(root == null) {
			return root;
		}

		if(root.left != null) {
			Node left = binaryTreeToDoubleLinkedList(root.left);

			while(left.right != null) {
				left = left.right;
			}

			left.right = root;
			root.left = left;
		}

		if(root.right != null) {
			Node right = binaryTreeToDoubleLinkedList(root.right);

			while(right.left != null) {
				right = right.left;
			}

			right.left = root;
			root.right = right;
		}

		return root;
	}

	public void printList(Node head) {
		while(head != null) {
			System.out.println(head.data + " ");
			head = head.right;
		}
	}

	public static void main(String[] args) {
		BinaryTreeToDoubleLinkedList tree = new BinaryTreeToDoubleLinkedList();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// Convert to DLL
		Node head = tree.binaryTreeToDoubleLinkedList(tree.root);

		if(head != null) {
			while(head.left != null) {
				head = head.left;
			}
		}

		// Print the converted list
		tree.printList(head);
	}
}
