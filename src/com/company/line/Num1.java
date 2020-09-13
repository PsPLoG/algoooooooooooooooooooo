package com.company.line;

import java.util.HashMap;

public class Num1 {
    static int count = 0;

    public static int solution(int[][] boxes) {
        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < boxes.length; i++) {
            set.put(boxes[i][0], set.getOrDefault(boxes[i][0], 0) + 1);
            set.put(boxes[i][1], set.getOrDefault(boxes[i][1], 0) + 1);
        }

        for (int e : set.keySet()) {
            if (set.get(e) % 2 == 0) {
                set.put(e, 0);
            }
        }
        for (int e : set.keySet()) {
            System.out.println("key" + e + " " + set.get(e));
        }

        for (int e : set.keySet()) {
            if (set.get(e) % 2 == 0) {
                set.put(e, 0);
            } else
                count++;
        }
        while (true) {
            int c = 0;
            for (int e : set.keySet()) {
                if (set.get(e) % 2 != 0) {
                    for (int i = 0; i < boxes.length; i++) {
                        if(set.get(e)==boxes[i][0]||set.get(e)==boxes[i][1]){
                            set.put(boxes[i][0], set.getOrDefault(boxes[i][0], 0) + 1);
                            set.put(boxes[i][1], set.getOrDefault(boxes[i][1], 0) + 1);
                        }
                    }
                }else {
                    set.put(e, 0);
                }
                if (c == 0)
                    break;
            }
            return count;
        }
    }
        public static void main (String[]args){
            int[][] a = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
            System.out.println(); solution(a);
        }
    }
