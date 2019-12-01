//package com.company.kakao;
//
//public class num4 {
//    long[] answer;
//    int[] room;
//    public int chekin(int num)
//    {
//        for (int i=num-1;i<room.length;i++)
//        {
//            if(room[i]==0) {
//                room[i] = 1;
//                return i+1;
//            }
//        }
//        return 0;
//    }
//    public long[] solution(long k, long[] room_number) {
//        answer = new long[(int)room_number.length];
//        room =  new int[(int)k];
//        for(int i=0;i<room_number.length;i++)
//        {
//            answer[i]=chekin((int)room_number[i]);
//        }
//        return answer;
//    }
//}
