package me.nyoung.Programmers.level2.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> conv = new HashMap<>();
        int count = (int)s.chars().filter(x -> x == '{').count()-1;
        String[] strs = s.split("\\{|,|\\}");
        int[] arr = new int[count];
        int[] answer = new int[count];
        for(String str : strs){
            if(str.equals("")) continue;
            int num = Integer.parseInt(str);

            if(map.get(num) == null) {
                map.put(num, map.size());
                conv.put(map.size()-1, num);
            }
            arr[map.get(num)]++;
        }

        for (int i = 0; i < count; i++) {
            answer[count-arr[i]] = conv.get(i);
        }
        return answer;
    }
}