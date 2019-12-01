//package com.company.hash;
//
//import java.util.HashMap;
//
//public class Q42576 {
//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        HashMap<String,Integer> hashMap = new HashMap();
//        HashMap<String,Integer> hashMap2 = new HashMap();
//
//        for(int i=0;i<participant.length;i++)
//        {
//            String t = participant[i];
//            hashMap.put(t,hashMap.getOrDefault(t,0)+1);
//
//            if(i<completion.length) {
//                String t1 = completion[i];
//                hashMap2.put(t1, hashMap2.getOrDefault(t1, 0) + 1);
//            }
//        }
////
//
//        for(String i : participant){
//            if(hashMap.getOrDefault(i,0).equals(hashMap2.get(i))){
//                answer=i;
//                break;
//            }
//            hashMap.remove(i);
//        }
//        return answer;
//    }
//}
