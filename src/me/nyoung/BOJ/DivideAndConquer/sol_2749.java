package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long b = sc.nextLong();
        long[][] A = new long[][]{{0, 1}, {1, 1}};
        long[][] result = b!=1 ? matPow(A, b-1) : A;
        System.out.println(result[1][1] % div);
    }

    static int div = 1000000;
    static long[][] matPow(long[][] A, long n){
        if(n == 1) return A;

        long[][] matrix = matPow(A, n/2);
        if(n % 2 == 0){
            A = matMul(matrix, matrix);
        }else{
            A = matMul(matMul(matrix, matrix), A);
        }

        return A;
    }

    static long[][] matMul(long[][] A, long[][] B){
        int n = A.length;
        int m = B.length;
        int k = B[0].length;
        long[][] result = new long[n][k];

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
