package com.company.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q49189 {

    public static int solution(int n, int[][] edge) {
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0] - 1;
            int y = edge[i][1] - 1;
            list.get(x).add(y);
            list.get(y).add(x);
        }

        Queue q = new LinkedList();
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int pop = (int) q.poll();
            LinkedList<Integer> te = list.get(pop);
            for (int i = 0; i < te.size(); i++) {
                int find = te.get(i);
                if (pop != find) {
                    if (!visited.contains(find)) {
                        q.add(find);
                        visited.add(find);
                        hash.put(find, hash.getOrDefault(pop, 0) + 1);
                    }
                }
            }
        }
        int max =0;
        int count =0;
        for (int e : hash.keySet()) {
            max=Math.max(max,hash.get(e));
        }
        for (int e : hash.keySet()) {
            if(hash.get(e)==max)
                count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int arr[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, arr));
    }
}
