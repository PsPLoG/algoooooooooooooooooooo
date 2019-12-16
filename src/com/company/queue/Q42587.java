//package com.company.queue;
//
//import java.util.ArrayList;
//
//public class Q42587 {
//    public int solution(int[] priorities, int location) {
//        int answer = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < priorities.length; i++)
//            list.add(priorities[i]);
//
//        while (true) {
//            int order = list.get(0);
//            for (int i = 1; i < list.size(); i++) {
//                if (order < list.get(i)) {
//                    list.remove(0);
//                    list.add(order);
//                }
//            }
//        }
//        return answer;
//    }
//}
