package com.company.graph;

import java.util.HashMap;

public class Q49189 {
    static int num;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void printMap(int[][] arr) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void surf(int[][] preMap, int preNode, int curNode, int deep, int target) {
        if (hashMap.getOrDefault(target, 100) < deep)
            return;

        if (curNode == target) {
            System.out.println("found"+ target+"pre :"+preNode+" cur:"+curNode + " deeep"+deep);
            if (hashMap.getOrDefault(target, 100) > deep)
                hashMap.put(target, deep);
        }
        int[][] map = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                map[i][j] = preMap[i][j];
            }
        }

        for (int i = 0; i < num; i++) {
            map[preNode][i] = 0;
            map[i][preNode] = 0;



        }
        for (int i = 0; i < num; i++) {
            if (map[curNode][i] == 1 && i != curNode) {
                surf(map, curNode, i, deep+1, target);
            }
        }


    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        int[][] map = new int[n][n];
        num = n;
        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0] - 1][edge[i][1] - 1] = 1;
            map[edge[i][1] - 1][edge[i][0] - 1] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (map[0][i] == 1) {
                for(int j =0;j<n;j++){
                    surf(map, 0, i, 1, j);
                }
            }
        }
        int max = 0;
        int count = 0;
        for (int e : hashMap.keySet()) {
            int current = hashMap.get(e);
            System.out.println(current+" "+(e+1));
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
