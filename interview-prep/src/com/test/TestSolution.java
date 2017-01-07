package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestSolution {

	static class Node {
		public List<Node> connections = new ArrayList<Node>();
		public String name;
		public boolean visited;

		public Node(String name) {
			this.name = name;
		}
	}

	public List<Node> result = new ArrayList<Node>();

	public List<Node> sendMessagesTo(List<Node> nodes, boolean parentVisited) {

		for(Node n : nodes) {
			if(!n.visited) {
				n.visited = true;

				if(!parentVisited) {
					result.add(n);
				}


				Iterator<Node> iterator = n.connections.iterator();
				while(iterator.hasNext()) {
					Node temp = iterator.next();
					if(!temp.visited) {
						temp.visited = true;
						sendMessagesTo(temp.connections, true);
					}
				}
			}
		}
		return result;
	}

	public void print(List<Node> nodes) {
		System.out.println("Output: ");
		for(Node n : nodes) {
			System.out.println(n.name);
		}
	}

	public static void main(String[] args) {
		TestSolution soln = new TestSolution();

		List<Node> input = new ArrayList<Node>();
		Node i = new Node("i");
		Node j = new Node("j");
		Node m = new Node("m");
		Node k = new Node("k");
		j.connections.add(m);
		j.connections.add(k);
		i.connections.add(j);

		input.add(i);
		input.add(j);
		input.add(m);
		input.add(k);

		List<Node> output = soln.sendMessagesTo(input, false);
		soln.print(output);

		soln.result.clear();

		List<Node> input1 = new ArrayList<Node>();
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");

		A.connections.add(B);
		B.connections.add(C);
		D.connections.add(E);

		input1.add(A);
		input1.add(B);
		input1.add(C);
		input1.add(D);
		input1.add(E);

		//		List<Node> output1 = soln.sendMessagesTo(input1, false);
		//		soln.print(output1);

		soln.result.clear();


		C.connections.add(A);
		List<Node> output1 = soln.sendMessagesTo(input1, false);
		soln.print(output1);

	}
}
