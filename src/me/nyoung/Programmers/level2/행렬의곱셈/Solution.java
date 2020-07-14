package me.nyoung.Programmers.level2.행렬의곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int sum = 0;
        //i = arr1 행갯수
        //j = arr2 열갯수
        //k = arr1 열갯수
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length;j++){
                sum = 0;
                for(int k = 0; k < arr2.length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}