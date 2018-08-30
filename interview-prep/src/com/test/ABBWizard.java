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

    class Wizard implements Comparable<Wizard> {
        int id;
        int dist;

        Wizard(int id) {
            this.id = id;
            this.dist = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Wizard that) {
            return this.dist - that.dist;
        }
    }


    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {

        if (wizards == null || wizards.size() == 0) {
            return null;
        }
        int n = wizards.size();
        int[] parent = new int[n];

        Map<Integer, Wizard> map = new HashMap<Integer, Wizard>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            map.put(i, new Wizard(i));
        }

        map.get(source).dist = 0;
        Queue<Wizard> pq = new PriorityQueue<Wizard>(n);
        pq.offer(map.get(source));

        while (!pq.isEmpty()) {
            Wizard curr = pq.poll();
            List<Integer> neighbors = wizards.get(curr.id);

            for (int neighbor : neighbors) {
                Wizard next = map.get(neighbor);
                int weight = (int) Math.pow(next.id - curr.id, 2);

                if (curr.dist + weight < next.dist) {
                    parent[next.id] = curr.id;
                    pq.remove(next);
                    next.dist = curr.dist + weight;
                    pq.offer(next);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int t = target;
        while (t != source) {
            res.add(t);
            t = parent[t];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
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

        ABBWizard sol = new ABBWizard();

        List<Integer> results = sol.getShortestPath(wizards, 0, 9);

        for (Integer result : results) {
            System.out.println(result);
        }
    }
}
