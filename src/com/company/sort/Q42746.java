//package com.company.sort;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//
//public class Q42746 {
//    public static void main(String[] args) {
//        int[] test = {3, 30, 34, 5, 9};
//
//    }
//
//    public static String fitStringSize(String a, int size){
//        for(int i=a.length()-1;i<size;i++)
//            a+=a.charAt(a.length()-1);
//        return a;
//    }
//    public static String solution(int[] numbers) {
//        String answer = "";
//        int size = numbers.length;
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < numbers.length; i++)
//            list.add(Integer.toString(numbers[i]));
//
//
//        Comparator<String> compare = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int size = o1.length();
//                int type=0;
//                if (o1.length() < o2.length()) {
//                    size = o2.length();
//                    o1=fitStringSize(o1,size);
//                    type=1;
//                } else if (o1.length() > o2.length()) {
//                    size = o1.length();
//                    o2=fitStringSize(o2,size);
//                    type=2;
//                }
//
//
//                if (o1.charAt(0) < o2.charAt(0)) {
//                    return 1;
//                } else if (o1.charAt(0) > o2.charAt(0)) {
//                    return -1;
//                }
//
//                if (size == 1)
//                    return 0;
//
//                for (int i = 1; i < size; i++) {
//                    if (o1.charAt(i) < o2.charAt(i)) {
//                        return -1;
//                    } else if (o1.charAt(i) > o2.charAt(i)) {
//                        return 1;
//                    }
//                }
//                if(type==1)
//                    return -1;
//                else if(type==2)
//                    return 1;
//                else return 0;
//            }
//        };
//        list.sort(compare);
//
//        for (int i = 0; i < numbers.length; i++) {
//            if(answer.equals("0") && list.get(i).equals("0"))
//                continue;
//                answer+=list.get(i);
//        }
//
//        return answer;
//    }
//}
