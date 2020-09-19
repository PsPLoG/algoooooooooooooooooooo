package com.company.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Q49189 {
    static int num;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static LinkedList<LinkedList<Integer>> map;
    public static void printMap(int[][] arr) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void surf(HashSet<Integer> visit, int preNode, int curNode, int deep, int target) {
        HashSet<Integer> test = new HashSet<>();
        visit.addAll(visit);
        if (hashMap.getOrDefault(target, num) < deep)
            return;

        if (curNode == target) {
            //System.out.println("found" + (1 + target) + "pre :" + preNode + " cur:" + curNode + " deeep" + deep);
            if (hashMap.getOrDefault(target, num) > deep)
                hashMap.put(target, deep);
        }
        for (int i = 0; i < map.get(curNode).size(); i++) {
            int find = map.get(curNode).get(i);
            if (find != preNode && test.contains(find) == false)
                surf(test, curNode, map.get(curNode).get(i), deep + 1, target);
        }


    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        map = new LinkedList<>();
        num = n;
        for (int i = 0; i < n; i++) {
            map.add(new LinkedList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int x =edge[i][0] - 1;
            int y =edge[i][1] - 1;
            map.get(x).add(y);
            map.get(y).add(x);
        }


        for (int i = 0; i < map.get(0).size(); i++) {
            for (int j = 1; j < n; j++) {
                surf(new HashSet<>(), 0, map.get(0).get(i), 1, j);
            }
        }
        int max = 0;
        int count = 0;
        for (int e : hashMap.keySet()) {
            int current = hashMap.get(e);
            if (current > max) {
                max = current;
            }
        }

        for (int e : hashMap.keySet()) {
            int current = hashMap.get(e);
            if (current == max) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, arr));
    }
}
