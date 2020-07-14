package me.nyoung.Programmers.level1.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format("%"+n+"s", answer[i]).replace('1', '#').replace('0', ' ');
        }

        return answer;
    }
}