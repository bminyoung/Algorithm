package me.nyoung.Programmers.level3.등굣길;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] ways = new int[n+1][m+1];
        int[][] d = new int[n+1][m+1];

        for(int i = 0; i < puddles.length; i++){
            ways[puddles[i][1]][puddles[i][0]] = -1;
        }

        d[1][0] = 1;
        for(int i = 1; i <= n; i++) {
            if(ways[i][1] != -1) d[i][1] = 1;
            for(int j = 1; j <= m; j++) {
                if(ways[i][j] == -1) {
                    d[i][j] = 0;
                }else {
                    d[i][j] = (d[i-1][j] + d[i][j-1]) % 1000000007;
                }
            }
        }

        return d[n][m];
    }
}