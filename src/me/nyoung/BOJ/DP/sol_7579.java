package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_7579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        int[][] d = new int[n+1][10001];
        int[] memory = new int[n+1];
        int[] cost = new int[n+1];
        for (int i = 1; i <= n; i++) {
            memory[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            cost[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10000; j++) {
                if(j-cost[i] >= 0) d[i][j] = Math.max(d[i-1][j], d[i-1][j-cost[i]] + memory[i]);
                else d[i][j] = d[i-1][j];

                if(d[i][j] >= M && min > j){
                    min = j;
                }
            }
        }
        System.out.println(min);
    }
}
