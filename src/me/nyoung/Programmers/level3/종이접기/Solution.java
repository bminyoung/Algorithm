package me.nyoung.Programmers.level3.종이접기;

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {0};
        ArrayList<Boolean> arr = new ArrayList<>();
        ArrayList<Boolean> tmp = new ArrayList<>();
        arr.add(false);

        for(int i = 1; i < n; i++) {
            tmp = new ArrayList<>(arr);
            arr.add(false);
            Collections.reverse(tmp);
            for(int j = 0; j < tmp.size(); j++) {
                tmp.set(j, !tmp.get(j));
            }
            arr.addAll(tmp);
        }

        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i) ? 1 : 0;
        }

        return answer;
    }
}