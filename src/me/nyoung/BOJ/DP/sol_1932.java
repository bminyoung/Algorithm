package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tri = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                tri[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            tri[i][0] += tri[i-1][0];
            for (int j = 1; j < i; j++) {
                tri[i][j] += Math.max(tri[i-1][j],tri[i-1][j-1]);
            }
            tri[i][i] += tri[i-1][i-1];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < tri[n-1][i]) max = tri[n-1][i];
        }
        System.out.println(max);
    }
}
