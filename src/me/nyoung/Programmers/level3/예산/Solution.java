package me.nyoung.Programmers.level3.예산;

class Solution {
    public int solution(int[] budgets, int M) {
        int min = 1;
        int max = 0;
        int mid;
        int answer = max;

        for(int b : budgets) {
            if(b > max) max = b;
        }

        while(min <= max) {

            mid = (min + max) / 2;
            int sum = 0;
            for(int budget : budgets) sum += budget <= mid ? budget : mid;

            if(sum <= M) {
                answer = mid;
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }

        return answer;
    }
}