//package com.company.kakao;
//
//public class num5 {
//    public static int solution(int[] stones, int k) {
//        int answer = 0;
//        boolean flag=true;
//        int state=0;
//        while(flag){
//            state=0;
//            for (int i = 0; i < stones.length; i++) {
//                if(stones[i]>0) {
//                    state=0;
//                    stones[i]--;
//                    if(i==stones.length-1) {
//                        answer++;
//                    }
//                }
//                else {
//                    if(state>=k) {
//                        flag = false;
//                        break;
//                    }else if(i==stones.length-1)
//                        answer++;
//                    state++;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int[] a ={2,4,5,3,2,1,4,2,5,1};
//        int k=3;
//        solution(a,k);
//    }
//}
