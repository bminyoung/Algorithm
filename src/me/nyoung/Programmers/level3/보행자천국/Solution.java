package me.nyoung.Programmers.level3.보행자천국;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        Corner[][] corners = new Corner[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                corners[i][j] = new Corner(cityMap[i][j]);
            }
        }

        for(int i = 1; i < m; i++) {
            if(corners[i][0].sign == 1) break;
            corners[i][0].above = 1;
        }

        for(int i = 1; i < n; i++) {
            if(corners[0][i].sign == 1) break;
            corners[0][i].side = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(corners[i][j].sign == 1) continue;

                Corner up = corners[i-1][j];
                Corner left = corners[i][j-1];

                corners[i][j].above = up.sign == 0 ? (up.above + up.side) % MOD : up.above;
                corners[i][j].side = left.sign == 0 ? (left.side + left.above) % MOD : left.side;
            }
        }

        return (corners[m-1][n-1].above + corners[m-1][n-1].side) % MOD;
    }

    class Corner{
        int sign;
        int above;
        int side;
        Corner(int sign){
            this.sign = sign;
        }
    }
}