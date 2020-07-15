package me.nyoung.Programmers.level1.같은숫자는싫어;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == prev) continue;
            prev = arr[i];
            list.add(arr[i]);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
