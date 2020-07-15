package me.nyoung.Programmers.level2.H_Index;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int[] reverse = new int[citations.length];
        Arrays.sort(citations);
        for (int i = citations.length-1; i >= 0; i--) {
            reverse[citations.length -1 - i] = citations[i];
        }


        for(int i = reverse[0]; i > 0; i--) {
            int count = 0;
            for (int j = 0; j < reverse.length; j++) {
                if(reverse[j] >= i) count++;
            }
            if(count >= i) return i;
        }
        return reverse[reverse.length - 1];
    }
}
