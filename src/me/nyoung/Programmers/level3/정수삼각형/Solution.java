package me.nyoung.Programmers.level3.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 1; i < triangle.length; i++){
            for(int j = 1; j < i; j++){
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
        }

        int len = triangle.length -1;
        for(int i = 0; i < triangle.length; i++){
            if(answer < triangle[len][i]){
                answer = triangle[len][i];
            }
        }

        return answer;
    }
}