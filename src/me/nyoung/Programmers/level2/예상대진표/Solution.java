package me.nyoung.Programmers.level2.예상대진표;

public class Solution {
    public int solution(int n, int a, int b){
        int answer = 1;

        while ( n > 0){
            a = a % 2 == 0 ? a/2 : a/2+1;
            b = b % 2 == 0 ? b/2 : b/2+1;

            if(a == b) break;
            answer++;
            n /= 2;
        }
        return answer;
    }
}
