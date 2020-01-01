package com.company.implement;

import java.util.ArrayList;
import java.util.HashMap;

public class Q42888 {
    static class Chat {
        public int type;
        public String uid;
    }

    static ArrayList<Chat> chatLog ;
    static HashMap<String, String> user;

    public static void analyzeLog(String[] records) {

        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            Chat c = new Chat();
            c.uid = arr[1];

            if (arr[0].equals("Enter")) {
                c.type = 0;
                user.put(arr[1], arr[2]);

            } else if (arr[0].equals("Leave")) {
                c.type = 1;

            } else if (arr[0].equals("Change")) {
                user.put(arr[1], arr[2]);
                continue;
            }
            chatLog.add(c);
        }
    }

    public static String[] solution(String[] record) {
        chatLog = new ArrayList<>();
        user = new HashMap<>();
        String result = "";
        analyzeLog(record);

        //["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < chatLog.size(); i++) {
            if (chatLog.get(i).type == 0) {
                list.add(user.get(chatLog.get(i).uid) + "님이 들어왔습니다.,");
            } else {
                list.add(user.get(chatLog.get(i).uid) + "님이 나갔습니다.,");
            }
        }
        String[] answer = new String[list.size()];
        answer = list.toArray(answer);
        return answer;
    }

    public static void main(String[] args) {

        solution()
    }
}
