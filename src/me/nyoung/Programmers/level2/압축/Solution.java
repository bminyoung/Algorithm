package me.nyoung.Programmers.level2.압축;

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> answerArr = new ArrayList<>();
        ArrayList<String> dict = new ArrayList<>();
        dict.add(""); //A:1 B:2 C:3
        for(int i = 0; i < 26; i++) { //step1
            dict.add((char)('A'+i) + "");
        }

        if(msg.length() == 1) return new int[] {dict.indexOf(msg)};

        while(true) {
            int index = 0;
            String str = msg.charAt(index++)+"";
            String prev = str;
            boolean isEnd = false;
            while(true) {
                if(!dict.contains(str)) {
                    answerArr.add(dict.indexOf(prev));
                    dict.add(str);
                    break;
                }else if(msg.equals(str)){
                    isEnd = true;
                    break;
                }
                prev = str;
                str += msg.charAt(index++);
            }

            if(isEnd) {
                answerArr.add(dict.indexOf(str));
                break;
            }else {
                msg = msg.substring(prev.length());
            }
        }

        answer = new int[answerArr.size()];
        for(int i = 0; i < answerArr.size(); i++) answer[i] = answerArr.get(i);

        return answer;
    }
}