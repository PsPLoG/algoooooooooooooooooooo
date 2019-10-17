//package com.company.dfs;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) {
//
//        ArrayList<Integer> list = new ArrayList();
//        Scanner sc = new Scanner(System.in);
//        int msg = sc.nextInt();
//        int consumerSize = sc.nextInt();
//        for (int i = 0; i < msg; i++) {
//            list.add(sc.nextInt());
//        }
//
//        int[] consumer = new int[consumerSize];
//        for (int i = 0; i < consumerSize; i++)
//            consumer[i] = 0;
//
//        int count = 0;
//        while (true) {
//            for (int i = 0; i < consumerSize; i++) {
//                if (consumer[i] == 0) {
//                    if (list.size() > 0) {
//                        consumer[i] = list.get(0);
//                        list.remove(0);
//                    }
//                }
//            }
//            for (int i = 0; i < consumerSize; i++) {
//                if (consumer[i] == 0) {
//                } else
//                    consumer[i]--;
//            }
//
//            int check=0;
//            for(int i =0;i<consumerSize;i++)
//            {
//                if(consumer[i]==0)
//                    check++;
//            }
//            count++;
//            if(check==consumerSize && list.size()==0)
//                break;
//        }
//        System.out.println(count);
//    }
//}