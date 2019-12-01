//package com.company.dfs;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Q42839 {
//    static int count = 0;
//    static HashMap<Integer,Integer> map = new HashMap<>();
//    public static boolean checkSosu(int num) {
//        if(num<=1)
//            return false;
//        for (int i = 2; i < num; i++) {
//            if (num % i == 0)
//                return false;
//        }
//
//        System.out.println(num);
//        return true;
//    }
//
//    public static void loop(ArrayList<Integer> list1, int num, int index) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.addAll(list1);
//        if (list.size() > 0) {
//            checkSosu(num);
//            num = num * 10;
//            num += list.get(index);
//            list.remove(index);
//
//            if (list.size() == 0) {
//                if(checkSosu(num))
//                    map.put(num,1);
//                return;
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            loop(list,num,i);
//        }
//    }
//
//    public static void main(String[] args) {
//        solution("17");
//    }
//    public static int solution(String numbers) {
//        int answer = 0;
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<numbers.length();i++) {
//            list.add(Integer.parseInt(numbers.charAt(i) + ""));
//        }
//
//        for(int i=0;i<numbers.length();i++)
//            loop(list,0,i);
//        return map.keySet().size();
//    }
//}
