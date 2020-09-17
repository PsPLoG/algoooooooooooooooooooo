package com.company.dfs;

public class Q12900 {
    static int n = 0;
    static int count = 0;

    public static void loop(int size) {
        if (size == n) {
            count = (count + 1) % 1000000007;
            return;
        } else if (size > n) {
            return;
        }

        loop(size + 1);
        loop(size + 2);
    }

    public static int solution(int num) {
        n = num;
        loop(1);
        loop(2);
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        solution(3000);
        //n == 2;
        /*
         * n == 1
         * A | 1
         *
         * n == 2
         * A ㅡ 2
         * B || 1 1
         *
         * n == 3
         * A ||| 1 1 1
         * B ㅡ| 2 1
         * B |ㅡ 1 2
         *
         * n == 4
         * A |||| 1 1 1 1
         * B ㅡㅡ 2 2
         * C ㅡ|| 2 1 1
         * C |ㅡ| 1 2 1
         * C ||ㅡ 1 1 2
         *
         * n == 5 [1 + (n-2) + (n-1)]
         * A |||| 1 1 1 1 1
         * B ㅡㅡ| 2 2 1
         * B ㅡ|ㅡ 2 1 2
         * B ㅡ|ㅡ 1 2 2
         * C ㅡ|| 2 1 1 1
         * C |ㅡ| 1 2 1 1
         * C ||ㅡ 1 1 2 1
         * C ||ㅡ 1 1 1 2
         * */
    }
}
