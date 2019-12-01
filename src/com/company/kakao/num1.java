//package com.company.kakao;
//
//import java.util.ArrayList;
//
//public class num1 {
//
//    static int answer = 0;
//    public static int[][] map;
//    public static ArrayList<Integer> list = new ArrayList<>();
//    public static void pickItem(int x){
//        for(int i=0;i<map.length;i++)
//        {
//            if(map[i][x]!=0)
//            {
//                System.out.println("pick"+map[i][x]);
//                list.add(map[i][x]);
//                map[i][x]=0;
//
//                break;
//            }
//        }
//    }
//    public static boolean checkItem()
//    {
//        if (list.size() < 2)
//            return false;
//
//        int preItem = list.get(list.size() - 1);
//        for (int i = list.size() - 2; i >= 0; i--) {
//            if (preItem == list.get(i)) {
//                answer+=2;
//                list.remove(i);
//                list.remove(i);
//                checkItem();
//                return true;
//            }else
//                preItem = list.get(i);
//        }
//        return false;
//
//    }
//    public static int solution() {
//        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
//        int[] moves = {1,5,3,5,1,2,1,4};
//        map = board;
//        for(int i=0;i<moves.length;i++)
//        {
//            pickItem(moves[i]-1);
//            checkItem();
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(solution());
//        System.out.println();
//    }
//}