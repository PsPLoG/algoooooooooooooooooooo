//package com.company.kakao;
//
//import java.sql.Time;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class Num_5 {
//    public static String solution(String play_time, String adv_time, String[] logs) {
//        if (play_time.equals(adv_time))
//            return "00:00:00";
//
//        Calendar play = Calendar.getInstance();
//        String[] tmp = play_time.split(":");
//        play.set(1970, 1, 1, Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
//
//        Calendar adv = Calendar.getInstance();
//        tmp = adv_time.split(":");
//        play.set(1970, 1, 1, Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
//
//        ArrayList<TimeItem> list = new ArrayList<>();
//        for (int i = 0; i < logs.length; i++) {
//xzfgtg
//            list.add(new TimeItem(startCal, endCal));
//        }
//        long max = 0;
//        Calendar zero = Calendar.getInstance();
//        Calendar zeroToEnd = Calendar.getInstance();
//
//        zero.set(1970, 0, 1);
//        System.out.println("zero : "+zero.getTimeInMillis());
//        long zerotime = zero.getTimeInMillis();
//        int n =1;
//        for (int i = (int) zerotime; i < play.getTimeInMillis(); i++) {
//            //System.out.println(i+" "+play.getTimeInMillis());
//            long currentTime =0;
//            zero.setTimeInMillis(i+zerotime);
//            zeroToEnd.setTimeInMillis(adv.getTimeInMillis()+(n++));
//            TimeItem temp = new TimeItem(zero,zeroToEnd);
//
//            for(int j =0;j<list.size();j++){
//                TimeItem item = list.get(j);
//                currentTime+= item.colipseTime(temp);
//            }
//
//            if(max < currentTime)
//                max =currentTime;
//        }
//        System.out.println(max);
//        String answer = "";
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
//        solution("02:03:55","00:14:15",logs);
//    }
//
//    static class TimeItem {
//        Calendar startTime;
//        Calendar endTime;
//
//        public TimeItem(Calendar star, Calendar end) {
//            startTime = star;
//            endTime = end;
//        }
//
//        public boolean isColipes(TimeItem item) {
//            if (startTime.compareTo(item.startTime) <= 0 && endTime.compareTo(item.startTime) >= 0) {
//                return true;
//            }
//            if (startTime.compareTo(item.endTime) == -1 && endTime.compareTo(item.endTime) == -1) {
//                return true;
//            }
//            return false;
//        }
//
//        public long colipseTime(TimeItem item) {
//            if (startTime.compareTo(item.startTime) == 1) {
//                return item.startTime.getTimeInMillis() - endTime.getTimeInMillis();
//            } else if (startTime.compareTo(item.startTime) == 0) {
//                return startTime.getTimeInMillis();
//            } else {
//                return startTime.getTimeInMillis() - item.endTime.getTimeInMillis();
//            }
//        }
//
//    }
//}
