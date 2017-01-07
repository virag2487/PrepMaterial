package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KthAncestor {

	public static class Node {
		int data;
		List<Node> children;

		public Node(int d) {
			this.data = d;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == this) {
				return true;
			}
			if(!(obj instanceof Node)) {
				return false;
			}
			Node other = (Node)obj;
			if(this.data != other.data) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			return result;
		}

		@Override
		public String toString() {
			return ("Node: " + this.data + " Children: " + this.children);
		}
	}

	Node root;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfTestCases = scan.nextInt();
		// System.out.println(numOfTestCases);

		for(int i = 0; i < numOfTestCases; i++) {

			KthAncestor solution = new KthAncestor();
			Map<Node, List<Node>> relationships = new HashMap<Node, List<Node>>();

			int numOfNodes = scan.nextInt();
			// System.out.println(numOfNodes);

			for(int j = 0; j < numOfNodes; j++) {
				int node1 = scan.nextInt();
				int node2 = scan.nextInt();

				Node n1 = new Node(node1);
				Node n2 = new Node(node2);

				if(node2 == 0) {
					solution.root = n1;
				}
				else {
					List<Node> children = relationships.get(n2);
					if(children == null) {
						children = new ArrayList<Node>();
					}
					children.add(n1);
					relationships.put(n2, children);
				}
			}

			for(Map.Entry<Node, List<Node>> entrySet : relationships.entrySet()) {
				entrySet.getKey().children = entrySet.getValue();
			}
			
			solution.root.children = relationships.get(solution.root);

			System.out.println("");
			// System.out.println(node1 + " " + node2);
		}

		int numOfQueries = scan.nextInt();
		// System.out.println(numOfQueries);

		for(int k = 0; k < numOfQueries; k++) {
			int q1 = scan.nextInt();
			if(q1 == 1) {
				int q2 = scan.nextInt();
				// System.out.println(q1 + " " + q2);
			}
			else {
				int q2 = scan.nextInt();
				int q3 = scan.nextInt();
				// System.out.println(q1 + " " + q2 + " " + q3);
			}
		}
	}
}
