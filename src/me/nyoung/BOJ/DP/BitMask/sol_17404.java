package me.nyoung.BOJ.DP.BitMask;

import java.util.Scanner;

public class sol_17404 {
    static int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        int[][] d = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int min = MAX;
        for (int i = 0; i < 3; i++) {
            d[0] = new int[]{MAX, MAX, MAX};
            d[0][i] = cost[0][i];

            for (int j = 1; j < n; j++) {
                d[j][0] = Math.min(d[j-1][1], d[j-1][2]) + cost[j][0];
                d[j][1] = Math.min(d[j-1][0], d[j-1][2]) + cost[j][1];
                d[j][2] = Math.min(d[j-1][0], d[j-1][1]) + cost[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if(j == i) continue;
                min = Math.min(min, d[n-1][j]);
            }
        }
        System.out.println(min);
    }
}
