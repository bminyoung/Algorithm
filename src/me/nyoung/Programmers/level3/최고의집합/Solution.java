package me.nyoung.Programmers.level3.최고의집합;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) return new int[]{-1};

        int num = s/n;
        int std = n - s%n;
        for(int i = 0; i < std; i++){
            answer[i] = num;
        }

        num++;
        for(int j = std; j < n; j++){
            answer[j] = num;
        }

        return answer;
    }
}