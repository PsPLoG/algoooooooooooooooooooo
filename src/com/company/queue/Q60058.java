package com.company.queue;

import java.util.ArrayList;
import java.util.Arrays;

public class Q60058 {
    public static ArrayList<Character> stack = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("결과 =" + solution("()))((()"));
    }

    public static String solution(String p) {
        String answer = "";
        return sort(p);
    }

    private static boolean isAlright(String str) {
        stack.clear();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                int index = stack.size() - 1;
                if (0 <= index && index < stack.size())
                    stack.remove(index);
                else
                    return false;
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    private static String sort(String p) {
        int leftCount = 0;
        int rightCount = 0;
        //System.out.println(p);

        if (isAlright(p) || p.equals(""))
            return p;

        for (char c : p.toCharArray()) {
            if (c == '(')
                leftCount++;
            else
                rightCount++;

            if (leftCount == rightCount) {
                // u
                String u = p.substring(0, leftCount + rightCount);
                // v
                String v = p.substring(leftCount + rightCount);

                if (isAlright(u)) {
                    return u + sort(v);
                } else {
                    v = "(" + sort(v) + ")";
                    String tmp = "";
                    for (int i = 1; i < u.length() - 1; i++) {
                        if (u.charAt(i) == '(')
                            tmp += ')';
                        else
                            tmp += '(';
                    }
                    return v + tmp;
                }
            }
        }
        return "?";
    }
}