package com.company.queue;

import java.util.*;

public class Q42626 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for( int i=0;i<scoville.length;i++){
            list.add(scoville[i]);
        }

        while(list.size()>1){
            int first = list.poll();
            int tmp =0;
            if(first<K){
                int second = list.peek();
                tmp = first+(second*2);
                list.remove();
                list.remove();
                list.add(tmp);
                answer++;
            }else{
                break;
            }
        }
        if(list.size()==1){
            if(list.peek()<K){
                return -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
