package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_11049 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Matrix[][] matrix = new Matrix[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) matrix[i][j] = new Matrix(sc.nextInt(), sc.nextInt(), 0);
                else matrix[i][j] = new Matrix(1, 1, Integer.MAX_VALUE);
            }
        }

        for (int interval = 1; interval < n; interval++) {
            for (int i = 0; i < n-interval; i++) {
                int j = i+interval;
                for (int k = i; k < j; k++) {
                    int count = matrix[i][k].calCount + matrix[k+1][j].calCount + matrix[i][k].row * matrix[i][k].col * matrix[k+1][j].col;
                    if(matrix[i][j].calCount > count){
                        matrix[i][j].calCount = count;
                        matrix[i][j].row = matrix[i][k].row;
                        matrix[i][j].col = matrix[k+1][j].col;
                    }
                }
            }
        }
        System.out.println(matrix[0][n-1].calCount);
    }
}

class Matrix{
    int row;
    int col;
    int calCount;

    Matrix(int row, int col, int calCount){
        this.row = row;
        this.col = col;
        this.calCount = calCount;
    }
}