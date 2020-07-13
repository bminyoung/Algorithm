package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        int[][] d = new int[k+1][n+1];
        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if(weight[j] <= i){
                    d[i][j] = Math.max(d[i][j-1], d[i-weight[j]][j-1] + value[j]);
                }else{
                    d[i][j] = d[i][j-1];
                }
            }
        }

        System.out.println(d[k][n]);
    }
}
