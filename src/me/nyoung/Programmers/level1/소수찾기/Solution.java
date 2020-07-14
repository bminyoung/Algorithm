package me.nyoung.Programmers.level1.소수찾기;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] ls = new int[n];
        for(int i = 0; i < n; i++) {
            ls[i] = i + 1;
        }

        for(int i = 1; i < Math.sqrt(n); i++) {
            if(ls[i] == 0) continue;
            for(int j = 2*ls[i] - 1; j < n; j += ls[i]) {
                ls[j] = 0;
            }
        }

        for(int k = 1; k < n; k++) {
            if(ls[k] != 0) answer++;
        }

        return answer;
    }
}