package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int cnt = 0; cnt < T; cnt++) {
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            int[][] d = new int[n+1][n+1];
            int[] sum = new int[n+1]; //누적합

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                sum[i] = sum[i-1] + arr[i];
            }

            for (int i = 2; i <= n; i++) {
                for (int j = i-1; j > 0; j--) {
                    d[j][i] = Integer.MAX_VALUE;
                    for (int k = j; k < i; k++) { //d[j][i] = minsum(j~i)
                        d[j][i] = Math.min(d[j][i], d[j][k] + d[k+1][i]);
                    }
                    d[j][i] += sum[i] - sum[j-1]; // sum(j~i)
                }
            }
            System.out.println(d[1][n]);
        }

    }
}
