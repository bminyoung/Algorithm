package me.nyoung.Programmers.level2.땅따먹기;

class Solution {
    int solution(int[][] land) {
        for(int i = 1; i < land.length; i++) {
            land[i][0] = land[i][0] + max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] = land[i][1] + max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] = land[i][2] + max(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] = land[i][3] + max(land[i-1][0], land[i-1][1], land[i-1][2]);
        }


        return Math.max(max(land[land.length-1][0], land[land.length-1][1], land[land.length-1][2]), land[land.length-1][3]);
    }

    public int max(int a, int b, int c) {
        if(a < b) {
            if(b < c) {
                return c;
            }else {
                return b;
            }
        }else if(a < c){
            return c;
        }else {
            return a;
        }
    }
}