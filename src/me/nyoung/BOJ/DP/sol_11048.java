package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_11048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n+1][m+1];
        int[] d = new int[m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            d[1] = d[1] + map[i][1];
            for (int j = 2; j <= m; j++) {
                d[j] = Math.max(d[j-1], d[j]) + map[i][j];
            }
        }
        System.out.println(d[m]);
    }
}
