package com.company.dfs;

import java.util.Arrays;
import java.util.HashMap;

public class Q1829 {
   // public static HashMap<Integer, Integer> hash = new HashMap<>();
    public static int[] DIR_X = {-1, 0, 1, 0};
    public static int[] DIR_Y = {0, 1, 0, -1};
    public static int[][] picture1;
    static int sizeArea = 0;
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;

    public static void search(int y, int x, int dir, int searchNum) {
        for (int i = 0; i < 4; i++) {
            if (searchNum == picture1[y + DIR_Y[i]][x + DIR_X[i]]) {
                picture1[y + DIR_Y[i]][x + DIR_X[i]] = 0;
                sizeArea++;
                //hash.put(searchNum, hash.getOrDefault(searchNum, 0) + 1);
                search(y + DIR_Y[i], x + DIR_X[i], i, searchNum);
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        picture1 = new int[m + 2][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                picture1[i + 1][j + 1] = picture[i][j];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (picture1[i][j] != 0) {
                    sizeArea=1;
                    int key = picture1[i][j];
                    picture1[i][j] = 0;
                    search(i, j, 0, key);
                    numberOfArea++;
                    if (maxSizeOfOneArea < sizeArea) {
                        maxSizeOfOneArea = sizeArea;
                    }

                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {

        int[][] map = {{1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};
        int[] answer = solution(6, 4, map);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
