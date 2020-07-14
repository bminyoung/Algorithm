package me.nyoung.Programmers.level3._2xn타일링;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int num1 = 1;
        int num2 = 2;
        if (n == 1 || n == 2) return n;

        int index = 2;
        while(index < n) {
            answer = (num1+num2) % 1000000007;
            num1 = num2;
            num2 = answer;
            index++;
        }

        return answer;
    }
}