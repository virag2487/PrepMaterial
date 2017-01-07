package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class which will read input from the console, and call the appropriate
 * command.
 * 
 * @author Virag Shah
 */
public class Jumpstart {

	// Each item is a node with list of dependencies
	class Node {

		private String name;
		// list of dependencies
		private List<Node> dependencies = new ArrayList<Node>();

		public Node(String name, List<Node> dependencies) {
			super();
			this.name = name;
			this.dependencies = dependencies;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Node> getDependencies() {
			return dependencies;
		}

		public void setDependencies(List<Node> dependencies) {
			this.dependencies = dependencies;
		}

		public void addDependency(Node dependency) {
			this.dependencies.add(dependency);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((dependencies == null) ? 0 : dependencies.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (dependencies == null) {
				if (other.dependencies != null)
					return false;
			} else if (!dependencies.equals(other.dependencies))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private Jumpstart getOuterType() {
			return Jumpstart.this;
		}


	}

	/**
	 * Input stream for commands
	 */
	private BufferedReader input;

	/**
	 * Output stream for results
	 */
	private PrintStream output;

	// map of all items
	private Map<String, Node> items = new HashMap<String, Node>();

	// list of installed components
	private Set<Node> installedComponents = new HashSet<Node>();

	/**
	 * Creates a new CommandParser, sending input and output to the specified
	 * locations
	 * 
	 * @param in
	 *            input stream for commmands
	 * @param out
	 *            output stream for results
	 */
	public Jumpstart(InputStream in, PrintStream out) {
		input = new BufferedReader(new InputStreamReader(in));
		output = out;
	}


	/**
	 * Processes a command from user. invalid commands are not printed, and
	 * silently ignored. An invalid command includes a command which is missing
	 * its argument. For example: "mkdir " is invalid.
	 * 
	 * @param line
	 *            line of text representing the command string
	 */
	public void processLine(String line) {

		// if line is empty, return
		if(line == null || line.trim().length() == 0) {
			return;
		}

		// split the input line based on space
		String[] splitLine = line.split("\\s+");

		// if empty, return
		if(splitLine == null || splitLine.length == 0) {
			return;
		}

		// Case 1: For DEPEND command
		if(splitLine[0].equals("DEPEND")) {
			// DEPEND case should have at least 2 items
			if(splitLine.length < 3) {
				return;
			}

			output.println(line);

			// get the node object from items map if present, else create new node and add it to items map
			Node node;
			if(items.containsKey(splitLine[1])) {
				node = items.get(splitLine[1]);
			}
			else {
				node = new Node(splitLine[1], new ArrayList<Node>());
				items.put(splitLine[1], node);
			}

			// Create the dependencies and add all nodes to items map
			for(int i = 2; i < splitLine.length; i++) {
				Node dependentNode;
				if(items.containsKey(splitLine[i])) {
					dependentNode = items.get(splitLine[i]);
				}
				else {
					dependentNode = new Node(splitLine[i], new ArrayList<Node>());
					items.put(splitLine[i], dependentNode);
				}

				node.addDependency(dependentNode);
			}
		}

		// Case 2: For INSTALL command
		else if(splitLine[0].equals("INSTALL")) {
			// INSTALL should have 1 item
			if(splitLine.length != 2) {
				return;
			}

			output.println(line);

			// get the node object from items map if present, else create new node and add it to items map
			Node node;
			if(items.containsKey(splitLine[1])) {
				node = items.get(splitLine[1]);
			}
			else {
				node = new Node(splitLine[1], new ArrayList<Node>());
				items.put(splitLine[1], node);
			}

			// If already installed
			if(installedComponents.contains(node)) {
				output.println("\t" + node.getName() + " is already installed.");
				return;
			}

			// resolve dependency and determine order of install
			List<Node> resolved = new ArrayList<Node>();
			try {
				resolveDependency(node, resolved, new ArrayList<Node>());
			} catch(Exception e) {
				e.printStackTrace();
			}

			// print the install order and add it to the installed components list for tracking
			for(Node n : resolved) {
				if(!installedComponents.contains(n)) {
					output.println("\tInstalling " + n.getName());
				}
				installedComponents.add(n);
			}
		}

		// Case 3: For REMOVE command
		else if(splitLine[0].equals("REMOVE")) {
			// REMOVE should have 1 item
			if(splitLine.length != 2) {
				return;
			}
			output.println(line);

			Node node = items.get(splitLine[1]);

			// if component not installed, then cannot remove
			if(!installedComponents.contains(node)) {
				output.println("\t" + node.getName() + " is not installed.");
				return;
			}

			// check if safe to remove
			boolean canRemove = safeToRemove(node);
			if(canRemove) {
				output.println("\tRemoving " + node.getName());
				installedComponents.remove(node);
			}
			else {
				output.println("\t" + node.getName() + " is still needed.");
				return;
			}

			// see if additional components can be removed based on this component being removed
			Iterator<Node> iterator = node.getDependencies().iterator();
			while(iterator.hasNext()) {
				Node n = iterator.next();
				canRemove = safeToRemove(n);
				if(canRemove) {
					output.println("\tRemoving " + n.getName());
					installedComponents.remove(n);
				}
			}
		}

		// Case 4: For LIST command
		else if(splitLine[0].equals("LIST")) {
			// LIST should have no attributes
			if(splitLine.length != 1) {
				return;
			}
			output.println(line);

			// list all installed components
			for(Node n : installedComponents) {
				output.println("\t" + n.getName());
			}
		}

		// Case 5: For END command
		else if(splitLine[0].equals("END")) {
			// END should have no attributes
			if(splitLine.length != 1) {
				return;
			}
			output.println(line);
		}
	}

	/**
	 * Determines the order of dependency installation. Used depth first search.
	 * 
	 * @param node
	 * @param resolved
	 * @param unresolved
	 * @throws Exception
	 */
	public void resolveDependency(Node node, List<Node> resolved, List<Node> unresolved) throws Exception {
		unresolved.add(node);
		for(Node n : node.dependencies) {
			if(!resolved.contains(n)) {
				if(unresolved.contains(n)) {
					throw new Exception("Circular reference detected:" + node.name + "->" + n.name);
				}
				resolveDependency(n, resolved, unresolved);
			}
		}
		resolved.add(node);
		unresolved.remove(node);
	}

	/**
	 * Determine if it is safe to remove a particular dependency
	 * 
	 * @param node
	 * @return
	 */
	public boolean safeToRemove(Node node) {
		boolean canRemove = true;
		for(Node n : items.values()) {
			if(n.getDependencies().contains(node) && installedComponents.contains(n)) {
				canRemove = false;
				break;
			}
		}
		return canRemove;
	}

	/**
	 * Reads all commands from the input, and executes them
	 * 
	 * @throws IOException
	 *             if a read error occurs while parsing commands
	 */
	public void process() throws IOException {
		String line = input.readLine();
		while (line != null && line.length() > 0) {
			processLine(line);
			line = input.readLine();
		}
	}


	/**
	 * Runs the parser on the supplied test data set. Expects a file in the
	 * current working directory. Output is sent to stdout
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		try {
			Jumpstart parser = new Jumpstart(new FileInputStream("test-input.dat"), System.out);
			parser.process();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}