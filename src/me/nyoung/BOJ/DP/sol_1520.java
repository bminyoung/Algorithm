package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_1520 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0, map, d));
    }

    static int[] x = new int[]{0,0,1,-1};
    static int[] y = new int[]{1,-1,0,0};
    static int dfs(int row, int col, int[][] map, int[][] d){
        if(row == map.length-1 && col == map[0].length-1) return 1;
        if(d[row][col] != -1) return d[row][col];

        d[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int nRow = row + x[i];
            int nCol = col + y[i];
            if(nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map[0].length) continue;

            if(map[row][col] > map[nRow][nCol]) {
                d[row][col] += dfs(nRow, nCol, map, d);
            }
        }
        return d[row][col];
    }
}
