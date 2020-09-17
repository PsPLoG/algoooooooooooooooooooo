package com.company.queue;

import java.util.ArrayList;

public class Q42587 {
    public static void main(String[] args) {
        int[] arr = {1,1,9,1,1,1};
        System.out.println(solution(arr,0));
    }
    static class Note {
        public Note(int order, int id) {
            this.order = order;
            this.id = id;
        }

        int order = 0;
        int id = 0;
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Note> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++)
            list.add(new Note(priorities[i], i));

        while (true) {
            Note order = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (order.order < list.get(i).order) {
                    list.remove(0);
                    list.add(order);
                    i = 0;
                    order = list.get(0);
                }
            }
            if (order.id == location)
                break;
            list.remove(0);
            System.out.println("pop");
            answer++;
        }
        return answer;
    }
}
