package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_1780 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        quad(map, 0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    static int minus = 0;
    static int zero = 0;
    static int one = 0;
    static void quad(int[][] map, int startX, int startY, int length) {
        StringBuilder sb = new StringBuilder();
        int std = map[startX][startY];
        boolean check = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(map[startX+i][startY+j] != std){
                    check = false;
                    i = length;
                    break;
                }
            }
        }
        if(!check){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    quad(map, startX + i*length/3, startY + j*length/3, length/3);
                }
            }
        }else{
            if(std == 0){
                zero++;
            }else if(std == 1){
                one++;
            }else{
                minus++;
            }
        }
    }
}
