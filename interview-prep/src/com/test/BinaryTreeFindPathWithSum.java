package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * All nodes along children pointers from root to leaf nodes form a path in a binary tree. 
 * Given a binary tree and a number, please print out all of paths where 
 * the sum of all nodes value is same as the given number.
 * 
 * For instance, if inputs are the binary tree in below figure and a number 47, 
 * two paths with be printed: One is the path contains node 10, 12 and 25, and the other contains 10, 15 and 22.
 * 
 * Input:
 * 							10
 * 						/		\
 * 					12				15
 * 					/	\			/
 * 				25		30		22
 * 
 * Output:
 * 				10 12 25
 * 				10 15 22
 * 
 * @author Virag
 *
 */
public class BinaryTreeFindPathWithSum {

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

	public void findPathWithSum(Node root, int sum) {
		if(root == null) {
			return;
		}

		int currentSum = 0;
		List<Integer> path = new ArrayList<Integer>();
		findPathWithSumHelper(root, sum, currentSum, path);
	}

	public void findPathWithSumHelper(Node root, int sum, int currentSum, List<Integer> path) {

		currentSum += root.data;
		path.add(root.data);

		if(sum == currentSum && root.left == null && root.right == null) {
			for(Integer value : path) {
				System.out.print(value + " ");
			}
			System.out.println("");
		}

		if(root.left != null) {
			findPathWithSumHelper(root.left, sum, currentSum, path);
		}
		if(root.right != null) {
			findPathWithSumHelper(root.right, sum, currentSum, path);
		}

		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		BinaryTreeFindPathWithSum tree = new BinaryTreeFindPathWithSum();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(22);

		tree.findPathWithSum(tree.root, 47);
	}
}