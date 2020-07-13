package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_10830 {
    static final int div = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long b = sc.nextLong();
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int[][] result = matPow(A, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]%div + " ");
            }
            System.out.println();
        }
    }

    static int[][] matPow(int[][] A, long n){
        if(n == 1) return A;

        int[][] matrix = matPow(A, n/2);
        if(n % 2 == 0){
            A = matMul(matrix, matrix);
        }else{
            A = matMul(matMul(matrix, matrix), A);
        }

        return A;
    }

    static int[][] matMul(int[][] A, int[][] B){
        int n = A.length;
        int m = B.length;
        int k = B[0].length;
        int[][] result = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    result[i][j] = (result[i][j] + A[i][l]*B[l][j]) % div;
                }
            }
        }
        return result;
    }
}
