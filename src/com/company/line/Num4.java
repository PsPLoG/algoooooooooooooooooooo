package com.company.line;

public class Num4 {//i j
    static int[] rootY = {1, 0, -1, 0};
    static int[] rootX = {0, 1, 0, -1};
    static int dir = 0;

    public static int setLeft() {
        dir++;
        if (dir > 3)
            dir = 0;

        return dir;
    }

    public static int setRight() {
        dir--;
        if (dir < 0)
            dir = 3;

        return dir;
    }
    public static void showMap(int[][] newMap){
        for (int i = 0; i < newMap.length; i++) {
            System.out.println();
            for (int j = 0; j < newMap[i].length; j++) {
                System.out.print(newMap[i][j]+" ");
            }
        }
    }
    public static int solution(int[][] maze) {
        int endY = maze.length ;
        int endX = maze[0].length;
        int count = 0;
        int[][] newMap = new int[maze.length+2][maze[0].length+2];
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[i].length; j++) {
                newMap[i][j] = 1;
            }
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                newMap[i + 1][j + 1] = maze[i][j];
            }
        }

        showMap(newMap);
        int coo=0;
        int y = 1, x = 1;

        while (true) {
            if (newMap[y + rootY[dir]][x + rootX[dir]] == 0) {
                y += rootY[dir];
                x += rootX[dir];
                count++;
                setLeft();

                System.out.println("?"+x+"asd"+y);
            } else {
                setRight();
            }
            if(y == endY && x==endX){
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
//
//

        int[][] maze = {{0,1,0,1},{0,1,0,0},{0,0,0,0},{1,0,1,0}};
        System.out.println(solution(maze));
    }
}
