package me.nyoung.Programmers.level2.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum = 0;

        for(int i = 1; i < n/2+1; i++){
            sum = 0;
            for(int j = i; j < n/2+2; j++){
                int target = (j-i)*(j+i-1);
                if(target == n * 2){
                    answer++;
                }else if(target > n * 2) break;
            }

        }

        return answer;
    }
}