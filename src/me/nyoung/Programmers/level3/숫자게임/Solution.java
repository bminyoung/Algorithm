package me.nyoung.Programmers.level3.숫자게임;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int bInd = B.length-1;
        for(int i = A.length-1; i >= 0; i--) {
            if(A[i] < B[bInd]) {
                answer++;
                bInd--;
            }
        }

        return answer;
    }
}