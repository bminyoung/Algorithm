package me.nyoung.BOJ.DP;

import java.util.Arrays;
import java.util.Scanner;

public class sol_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n+1];
        int[][] d = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }

        Arrays.sort(coin);

        for (int i = 1; i <= k; i++) { // goal : i won
            d[0][i] = -1;
            for (int j = 1; j <= n; j++) { //coin : 1~j
                d[j][i] = d[j-1][i];
                if(i-coin[j] >= 0 && d[j][i-coin[j]] != -1){
                    if(d[j][i] == -1) d[j][i] = d[j][i-coin[j]] + 1;
                    else d[j][i] = Math.min(d[j][i], d[j][i-coin[j]] + 1);
                }
            }
        }
        System.out.println(d[n][k]);
    }
}
