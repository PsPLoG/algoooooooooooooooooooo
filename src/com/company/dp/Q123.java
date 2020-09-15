package com.company.dp;

import java.util.ArrayList;
import java.util.Comparator;

public class Q123 {
    static class ProcessTime {
        public ProcessTime(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public long startTime;
        public long endTime;

        public boolean isInTime(long time) {
            if (time <= startTime && startTime-999 <= time || time <= endTime && endTime-999 <= time)
                return true;
            return false;
        }

        @Override
        public String toString() {
            return "ProcessTime{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    public static long timetToLong(String time) {
        long result = 0;
        String[] temp = time.split(":");
        result += (Double.parseDouble(temp[2]) * 1000d);
        result += Long.parseLong(temp[1]) * 60000;
        result += Long.parseLong(temp[0]) * 3600000;
        return result;
    }

    public static long secondtToLong(String time) {
        long result = 0;
        time = time.replace("s", "");
        result += (Double.parseDouble(time) * 1000d);
        return result;
    }

    public static int solution(String[] lines) {
        ArrayList<ProcessTime> list = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String[] temp = lines[i].split(" ");
            list.add(new ProcessTime(timetToLong(temp[1]) - secondtToLong(temp[2]) , timetToLong(temp[1])));
        }

        int max = 0;
        for (int i = 0; i <list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).isInTime(list.get(i).startTime)) {

                    System.out.println(list.get(j).toString() + " ?:" + list.get(i).endTime);
                    count++;
                }
            }
            System.out.println("=-----------");
            if (count > max) {
                max = count;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).isInTime(list.get(i).endTime)) {

                    System.out.println(list.get(j).toString() + " ?:" + list.get(i).endTime);
                    count++;
                }
            }

            System.out.println("=-----------");
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        String[] line = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(line));
    }
}
