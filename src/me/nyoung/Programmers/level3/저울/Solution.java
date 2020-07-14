package me.nyoung.Programmers.level3.저울;

import java.util.*;

class Solution {
    public int solution(int[] weight) {
        int[] possible = new int[weight.length];
        Arrays.sort(weight);
        if(weight[0] != 1) return 1;
        possible[0]= 1;

        for(int i = 1; i < weight.length; i++) {
            if(possible[i-1]+1 < weight[i]) {
                return possible[i-1]+1;
            }
            possible[i] = possible[i-1] + weight[i];
        }

        return possible[possible.length-1]+1;
    }
}