package com.company.kakao;

import java.util.ArrayList;
import java.util.LinkedList;

public class Num_3 {
    public static int[] solution(String[] info, String[] query) {
        DataSystem dataSystem = new DataSystem();
        for (int i = 0; i < info.length; i++) {
            dataSystem.addData(Data.parse(info[i]));
        }


        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] tmp = query[i].replace(" and", "").split(" ");
            result[i] = dataSystem.find(tmp[0], tmp[1], tmp[2], tmp[3], Integer.parseInt(tmp[4]));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] quret = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(solution(info, quret)[0]);

    }

    static class Data {
        String lang;
        String develop;
        String year;
        String food;
        int score;

        @Override
        public String toString() {
            return "Data{" +
                    "lang='" + lang + '\'' +
                    ", develop='" + develop + '\'' +
                    ", year='" + year + '\'' +
                    ", food='" + food + '\'' +
                    ", score=" + score +
                    '}';
        }

        public static Data parse(String data) {
            String[] tmp = data.split(" ");
            Data item = new Data();
            item.lang = tmp[0];
            item.develop = tmp[1];
            item.year = tmp[2];
            item.food = tmp[3];
            item.score = Integer.parseInt(tmp[4]);
            return item;
        }
    }

    static class DataSystem {
        public LinkedList<Data> data = new LinkedList();
        public LinkedList<Data> cpp = new LinkedList();
        public LinkedList<Data> java = new LinkedList();
        public LinkedList<Data> python = new LinkedList();
        public void addData(Data add){
            data.add(add);
            if(add.lang.equals("cpp"))
                cpp.add(add);
            else if(add.lang.equals("java"))
                java.add(add);
            else if(add.lang.equals("python"))
                python.add(add);

        }
        public int find(String lang, String develop, String year, String food, int score) {
            int count = 0;
            LinkedList<Data> db;
            if(lang.equals("cpp"))
                db =cpp;
            else if(lang.equals("java"))
                db =java;
            else if(lang.equals("python"))
                db =python;
            else
                db = data;
            for (int i = 0; i < db.size(); i++) {
                int check = 0;
                Data currentData = db.get(i);

                if (currentData.lang.equals(lang) || lang.equals("-")) {
                    check++;
                }
                if (currentData.develop.equals(develop) || develop.equals("-")) {
                    check++;
                }
                if (currentData.year.equals(year) || year .equals("-")) {
                    check++;
                }
                if (currentData.food.equals(food) || food.equals("-")) {
                    check++;
                }
                if (currentData.score >= score) {
                    check++;
                }
                if (check == 5) {
                    count++;
                }
            }
            return count;
        }
    }
}
