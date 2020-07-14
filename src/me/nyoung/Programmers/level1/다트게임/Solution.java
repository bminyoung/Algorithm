package me.nyoung.Programmers.level1.다트게임;

class Solution {
    final int chance = 3;
    public int solution(String dartResult) {
        int[] score = new int[chance];
        int index = 0;

        for(int i = 0; i < chance; i++) {
            score[i] = dartResult.charAt(index++)-'0';
            if(score[i] == 1) {
                if(dartResult.charAt(index) == '0') {
                    score[i] = 10;
                    index++;
                }
            }

            char mul = dartResult.charAt(index++);
            if(mul == 'D') score[i] = score[i] * score[i];
            else if(mul == 'T') score[i] = score[i] * score[i] * score[i];

            if(index >= dartResult.length()) break;
            mul = dartResult.charAt(index++);
            if(mul == '#') score[i] = -score[i];
            else if(mul == '*') {
                score[i] *= 2;
                if(i != 0) score[i-1] *= 2;
            }
            else index--;
        }
        int sum = 0;
        for(int i = 0; i < chance; i++) {
            sum += score[i];
        }

        return sum;
    }
}