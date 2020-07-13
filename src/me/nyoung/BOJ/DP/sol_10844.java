package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_10844 {
    static final int div = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][10];

        for(int i = 0; i < 10; i++){
            d[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            d[i][0] = d[i-1][1];
            for(int j = 1; j < 9; j++){
                d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % div;
            }
            d[i][9] = d[i-1][8];
        }

        long sum = 0;
        for(int i = 1; i < 10; i++){
            sum = sum + d[n][i];
        }
        System.out.println(sum % div);
    }
}
