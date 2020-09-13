package com.company.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Num_2 {
    public static String[] solution(String[] orders, int[] course) {
        HashMap<Character,Integer> hash= new HashMap();
        for(int i=0;i<orders.length;i++){
            String tmp = orders[i];
            for(int j=0;j<tmp.length();j++){
                hash.put(tmp.charAt(j),hash.getOrDefault(tmp.charAt(j),0)+1);
            }
        }
        int[] foodCount = new int[hash.keySet().size()];
        int k=0;
        for(char e : hash.keySet()){
            foodCount[k++]=hash.get(e);
        }

        Arrays.sort(foodCount);
        for(int i=0;i<foodCount.length;i++){
            int size = foodCount[i];
            String menu =size+":";
            for(char e : hash.keySet()){
                if(hash.get(e)==size)
                    menu+=e;
            }
            System.out.println(menu);
        }


        String[] answer = {};
        return answer;
    }
    public static void main(String[] args) {
        String[] order = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] corse = {2,3,5};
        solution(order,corse);
    }
}
