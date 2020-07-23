package me.nyoung.BOJ.BackTracking;

import java.util.Scanner;

public class sol_2580 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
        solve(sudoku);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j] != 0) continue;

                for (int k = 1; k <= 9; k++) {
                    sudoku[i][j] = k;
                    if(i == 8 && j == 8 && k == 4){
                        int a = 0;
                    }
                    if(check(sudoku, i, j)){
                        boolean result = solve(sudoku);
                        if(result){
                            return true;
                        }
                    }
                    sudoku[i][j] = 0;
                }

                if(sudoku[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static boolean check(int[][] sudoku, int row, int col) {
        boolean[] exist = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int num = sudoku[row][i];
            if(num != 0 && exist[num]) return false;
            exist[num] = true;
        }

        exist = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int num = sudoku[i][col];
            if(num != 0 && exist[num]) return false;
            exist[num] = true;
        }

        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        exist = new boolean[10];
        for (int i = rowStart; i < rowStart+3; i++) {
            for (int j = colStart; j < colStart+3; j++) {
                int num = sudoku[i][j];
                if(num != 0 && exist[num]) return false;
                exist[num] = true;
            }
        }
        return true;
    }
}
