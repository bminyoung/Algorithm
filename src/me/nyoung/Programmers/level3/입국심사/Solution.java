package me.nyoung.Programmers.level3.입국심사;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        if(times.length == 1) return times[0] * n;

        Arrays.sort(times);
        long min = 1;
        long max = (long)times[times.length-1] * n;
        long totalTime;
        long people = 0;
        long answer = max;

        while(min <= max) {
            people = 0;
            totalTime = (max + min) / 2;

            for(int time : times) {
                people += totalTime / time;
            }

            if(people < n) {
                min = totalTime + 1;
            }else if(people >= n){
                if(totalTime < answer) {
                    answer = totalTime;
                }
                max = totalTime - 1;
            }
        }

        return answer;
    }
}