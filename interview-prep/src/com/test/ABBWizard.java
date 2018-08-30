package com.test;

import java.util.*;

/**
 * ABB question
 * 
 * There are 10 people at a wizard meetup. Each wizard has levels 0 – 9 (the index of the input) and  knows a few other wizards there. 
 * Your job is to find the cheapest way for wizard 0 to meet wizard 9. Introductions have a cost that equals the square of the difference in levels. 
 * Goal: Level 0 wizard wants to meet level 9 using the fewest possible magic points. 
 * Cost: square of difference of levels 
 * The index of the array represents the level (0-9). 
 * the value is an array with the index of the other people each person knows. 
 * Note that relationships are one directional (e.g. 2 can introduce you to 3 but not vice versa). 
 * e.g. Min cost: 23 Min path: [0, 1, 4, 6, 9]. 
 */

class ABBWizard {

    static class Node implements Comparable<Node> {
        int id;
        int cost;

        Node(int id) {
            this.id = id;
            this.cost = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Node that) {
            return this.cost - that.cost;
        }
    }

    /**
     * Shortest path algorithm
     * 
     * @param wizards
     * @param source
     * @param target
     * @return
     */
    public List<Integer> cheapestWayToMeet(List<List<Integer>> wizards, int source, int target) {

        if (wizards == null || wizards.size() == 0) {
            return null;
        }

        int n = wizards.size();
        int[] parent = new int[n];

        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            nodeMap.put(i, new Node(i));
        }

        nodeMap.get(source).cost = 0;
        Queue<Node> queue = new PriorityQueue<Node>(n);
        queue.offer(nodeMap.get(source));

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            List<Integer> neighbors = wizards.get(curr.id);

            for (int neighbor : neighbors) {
                Node next = nodeMap.get(neighbor);
                int cost = (int) Math.pow(next.id - curr.id, 2);

                if (curr.cost + cost < next.cost) {
                    parent[next.id] = curr.id;
                    queue.remove(next);
                    next.cost = curr.cost + cost;
                    queue.offer(next);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int t = target;
        while (t != source) {
            result.add(t);
            t = parent[t];
        }
        result.add(source);
        Collections.reverse(result);
        return result;
    }

    /* public int minimumDistance(int shortestDistance[], boolean visited[]) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < 9; i++) {

            if(visited[i] == false && shortestDistance[i] <= min) {
                min = shortestDistance[i];
                index = i;

            }
        }
        return index;
    }

    public int[] shortestPath(List<List<Integer>> input, int startPoint) {

        int shortestDistance[] = new int[9];
        boolean visited[] = new boolean[9];

        for(int i = 0; i < 9; i++) {

            shortestDistance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        shortestDistance[startPoint] = 0;

        for(int i = 0; i < 8; i++) {

            int k = minimumDistance(shortestDistance, visited);

            visited[k] = true;

            for(int j = 0; j < 9; j++) {

                if(!visited[j] && input.get(k).size() > j && shortestDistance[k] != Integer.MAX_VALUE && 
                shortestDistance[k] + input.get(k).get(j) < shortestDistance[j]) {

                    shortestDistance[j] = shortestDistance[k] + input.get(k).get(j);
                }
            }
        }

        return shortestDistance;
    } */

    public static void main(String[] args) {

        ABBWizard sol = new ABBWizard();

        List<List<Integer>> wizards = Arrays.asList(
                Arrays.asList(1, 2, 3), // Wizard 0
                Arrays.asList(8, 6, 4), // Wizard 1
                Arrays.asList(7, 8, 3), // Wizard 2
                Arrays.asList(8, 1),    // Wizard 3
                Arrays.asList(6),       // Wizard 4
                Arrays.asList(8, 7),    // Wizard 5
                Arrays.asList(9, 4),    // Wizard 6
                Arrays.asList(4, 6),    // Wizard 7
                Arrays.asList(1),       // Wizard 8
                Arrays.asList(1, 4)     // Wizard 9   
                );

        List<Integer> results = sol.cheapestWayToMeet(wizards, 0, 9);

        for (Integer result : results) {
            System.out.println(result);
        }
    }
}
