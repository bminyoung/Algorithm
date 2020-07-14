package me.nyoung.Programmers.level2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> id = new HashMap<>();
        String[] gubun;
        int count = 0;
        for(String msg : record) {
            gubun = msg.split(" ");
            if(gubun[0].equals("Enter")) {
                id.put(gubun[1], gubun[2]);
                count++;
            }else if(gubun[0].equals("Change")) {
                id.put(gubun[1], gubun[2]);
            }else count++;
        }

        String[] answer = new String[count];
        int index = 0;
        for(int i = 0; i < record.length; i++) {
            gubun = record[i].split(" ");
            if(gubun[0].equals("Enter")) {
                answer[index++] = String.format("%s님이 들어왔습니다.", id.get(gubun[1]));
            }else if(gubun[0].equals("Leave")) {
                answer[index++] = String.format("%s님이 나갔습니다.", id.get(gubun[1]));
            }
        }
        return answer;
    }
}