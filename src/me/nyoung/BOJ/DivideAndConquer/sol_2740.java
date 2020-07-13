package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_2740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        sc.nextInt(); //m
        int k = sc.nextInt();
        int[][] B = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        int[][] result = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    result[i][j] += A[i][l]*B[l][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
