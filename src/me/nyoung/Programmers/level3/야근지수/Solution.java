package me.nyoung.Programmers.level3.야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long check = 0;
        for(int work : works) check += work;
        if(check <= n) return 0;

        Arrays.sort(works);

        int index = works.length-1;
        int max = works[index--];
        int rem = 0;

        while(n > 0) {
            while(index >= 0 && works[index] == max) {
                index--;
            }

            int num = works.length-1 - index;
            int diff = index == -1 ? n : max - works[index];

            if(n >= num*diff) {
                n -= num*diff;
            }else {
                diff = n / num;
                rem = n % num;
                n = 0;
            }

            for(int i = index+1; i < works.length; i++) {
                works[i] -= diff;
            }

            if(index >= 0) max = works[index];
        }

        for(int i = works.length - rem; i < works.length; i++) {
            if(works[i] > 0) works[i]--;
        }

        if(works[0] == 0) return 0;

        for(int i = 0; i < works.length; i++) {
            answer += (long)works[i] * (long)works[i];
        }

        return answer;
    }
}