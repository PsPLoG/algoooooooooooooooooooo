package com.company.implement;

import java.util.ArrayList;

public class Q17677 {
    public static ArrayList<String> splitString(String t) {
        ArrayList<String> list = new ArrayList();
        t = t.toUpperCase();
        for (int i = 0; i < t.length() - 1; i++) {
            String tmp = t.charAt(i) + "" + t.charAt(i + 1);

            if ('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z' && 'A' <= tmp.charAt(1) && tmp.charAt(1) <= 'Z')
                list.add(tmp);
        }
        return list;
    }

    public static int solution(String str1, String str2) {
        double answer = 0;
        ArrayList<String> s1 = splitString(str1);
        ArrayList<String> s2 = splitString(str2);

        if (s1.size() < s2.size()) {
            ArrayList<String> t = s1;
            s1 = s2;
            s2 = t;
        }

        double intersection = 0;
        double union = 0;


        while (s1.size() > 0) {
            String search = s1.get(0);
            s1.remove(0);
            int a = 1;
            int b = 0;
            for (int i = 0; i < s1.size(); i++) {
                if (search.equals(s1.get(i))) {
                    a++;
                    s1.remove(i--);
                }
            }
            for (int i = 0; i < s2.size(); i++) {
                if (search.equals(s2.get(i))) {
                    b++;
                    s2.remove(i--);
                }
            }


            if (a > b) {
                union +=a;
                intersection +=b;
            }else{
                union +=b;
                intersection +=a;
            }
        }

        union+=s2.size();
        answer = intersection / union;
        if(intersection + union == intersection)
            answer =1;
        else if(intersection == 0){
            answer =0;
        }
        else if(union ==0)
        {
            answer=1;
        }
        return (int) (answer * 65536);
    }

    public static void main(String[] args) {
        solution("E=M*C^2", "e=m*c^2");
    }
}
