package me.nyoung.Programmers.level1.예산;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = d.length;
        int sum = 0;

        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            if(sum + d[i] > budget){
                answer = i;
                break;
            }
            sum += d[i];
        }

        return answer;
    }
}
