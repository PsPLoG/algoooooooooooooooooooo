package com.company.line;

import java.util.ArrayList;

public class Num2 {
    public static ArrayList<Integer> q = new ArrayList<>();
    public static ArrayList<Integer> solve = new ArrayList<>();

    public static int[] solution(int[] ball, int[] order) {
        int[] result = new int[ball.length];
        int resultIndex = 0;
        for (int i = 0; i < ball.length; i++) {
            q.add(ball[i]);
        }

        for (int i = 0; i < order.length; i++) {
            solve.add(order[i]);
        }
        int search = 0;
        while (q.size() > 0) {
            int findNumber = solve.get(search);

            if (findNumber == q.get(0)) {
                result[resultIndex++] = q.get(0);
                q.remove(0);
                solve.remove(search);
                search = 0;

            } else if (findNumber == q.get(q.size() - 1)) {
                result[resultIndex++] = q.get(q.size() - 1);
                q.remove(q.size() - 1);
                solve.remove(search);
                search = 0;

            } else {
                search++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {6, 2, 5, 1, 4, 3};
        solution(a, b);
    }
}
