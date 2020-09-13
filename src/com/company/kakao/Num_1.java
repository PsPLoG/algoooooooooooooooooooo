package com.company.kakao;

public class Num_1 {
//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

    public static String solution(String new_id) {
        String result = "";
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        for (int i = 0; i < new_id.length(); i++) {
            char t = new_id.charAt(i);
            if ('A' <= t && t <= 'Z')
                result += (char) (t + 32);
            else
                result += t;
        }

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = result;
        result = "";
        for (int i = 0; i < new_id.length(); i++) {
            char t = new_id.charAt(i);
            if ('a' <= t && t <= 'z')
                result += t;
            else if (t == '-' || t == '_' || t == '.')
                result += t;
            else if ('0' <= t && t <= '9')
                result += t;
        }

        new_id = result;
        result = "";

//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < new_id.length(); i++) {
            char t = new_id.charAt(i);
            result += t;

            if (new_id.charAt(i) == '.') {
                while (i +1< new_id.length()) {
                    if (new_id.charAt(i + 1) == '.')
                        i++;
                    else break;
                }
            }

        }
        System.out.println(result);
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (result.equals(""))
            result = "a";

        if (result.charAt(0) == '.')
            result = result.substring(1);

        if (result.equals(""))
            result = "a";
        if (result.charAt(result.length() - 1) == '.')
            result = result.substring(0, result.length() - 1);

        if (result.equals(""))
            result = "a";

        if (result.length() > 15) {
            result = result.substring(0, 15);
        }

        if (result.length() < 3) {
            while (result.length() < 3) {
                result += result.charAt(result.length() - 1);
            }
        }

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("....!@BaT#*...y.abcdefghijklm"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
