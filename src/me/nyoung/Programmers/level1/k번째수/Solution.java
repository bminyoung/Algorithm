package me.nyoung.Programmers.level1.k번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];

            int[] param;
            param = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(param);
            answer[i] = param[index-1];
        }
        return answer;
    }
}
