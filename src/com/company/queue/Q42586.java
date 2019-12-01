//package com.company.queue;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Q42586 {
//
//    public static void main(String[] args) {
//        int[] pro = {15, 1, 14, 9, 29, 25, 17, 24, 4, 27, 7, 19, 29, 14, 23, 4, 21, 3, 8, 14};
//        int[] spe = {9, 11, 21, 16, 11, 21, 7, 5, 6, 30, 11, 24, 26, 18, 20, 18, 15, 30, 7, 18};
//        int[] answer = solution(pro, spe);
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }
//    }
//
//    public static int[] solution(int[] progresses, int[] speeds) {
//        int[] answer = {};
//
//        List<Integer> progress = Arrays.stream(progresses).boxed().collect(Collectors.toList());
//        List<Integer> speed = Arrays.stream(speeds).boxed().collect(Collectors.toList());
//        List<Integer> result = new ArrayList<>();
//
//        while (true) {
//            if (progress.size() == 0)
//                break;
//            for (int i = 0; i < progress.size(); i++) {
//                progress.set(i, progress.get(i) + speed.get(i));
//            }
//            if (progress.get(0) >= 100) {
//                int count = 0;
//                for (int i = 0; i < progress.size(); i++) {
//                    if (progress.get(i) >= 100) {
//                        count++;
//                        progress.remove(i);
//                        speed.remove(i);
//                        i--;
//                    }else
//                    {
//                        break;
//                    }
//                }
//                if (count > 0) {
//                    result.add(count);
//                }
//                break;
//            }
//
//
//        }
//        answer = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            answer[i] = result.get(i);
//        }
//
//        return answer;
//    }
//}
