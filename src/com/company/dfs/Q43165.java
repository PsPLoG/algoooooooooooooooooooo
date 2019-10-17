//package com.company.dfs;
//
//import java.util.Arrays;
//
//public class Q43165 {
//    static class Data {
//        int[] data = {0, 0, 0, 0, 0};
//    }
//
//    public static int count = 0;
//
//    public static boolean isThree(Data data) {
//        int count = 0;
//        for (int e : data.data) {
//            if (e == 1)
//                count++;
//        }
//        if (count == 2) return true;
//        else return true;
//    }
//
//    public static void loop(Data data, int index) {
//        System.out.println(index);
//        if (isThree(data))
//            count++;
//        if (index == 4)
//            return;
//        for (int i = index; i < 5; i++) {
//            Data tmp = data;
//            tmp.data[i] = tmp.data[i] ^ 1;
//            loop(tmp, index+1);
//        }
//    }
//
//    public static int solution(int[] numbers, int target) {
//        int answer = 0;
//        return answer;
//    }
//
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            Data tmp = new Data();
//            tmp.data[i] = tmp.data[i] ^ 1;
//            loop(tmp, 0);
//        }
//        System.out.println(count);
//    }
//}
