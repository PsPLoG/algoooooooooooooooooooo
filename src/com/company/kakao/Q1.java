package com.company.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q1 {
    public static void main(String[] args) {
        solution("abcabcdede");}

    public static int solution(String str) {
        if (str.length()==1)
            return 1;
        int[] result = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            ArrayList<String> list = new ArrayList();
            for (int j = 0; j < str.length(); j += i) {
                int lastIndex = j + i;
                if (lastIndex > str.length())
                    lastIndex = str.length();
                list.add(str.substring(j, lastIndex));
            }
            String ret = "";
            int count = 0;
            String lastString = "";
            while (list.size() > 0) {
                if(list.size()<2){
                    if(list.get(0).equals(lastString)) {
                        count++;
                        ret += count + list.get(0);
                    }
                    else{
                        ret += list.get(0);
                    }
                }
                else if (list.get(0).equals(list.get(1))) {
                    count++;
                } else {
                    if (count > 0) {
                        ret += count + list.get(0);
                        count = 0;
                    }else{
                        ret += list.get(0);
                    }
                }
                lastString = list.get(0);
                list.remove(0);
            }
            result[i-1]=ret.length();
            System.out.println("ret :" + ret + " size" + ret.length());
        }
        Arrays.sort(result);
        System.out.println(result[1]);
        return result[1];
    }
}
