package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_2630 {
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        count(map, 0, 0, map.length);
        System.out.println(white);
        System.out.println(blue);
    }

    static void count(int[][] map, int startX, int startY, int length) {
        int std = map[startX][startY];
        boolean success = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(map[startX+i][startY+j] != std){
                    success = false;
                    i = length;
                    break;
                }
            }
        }
        if(!success) {
            count(map, startX, startY, length/2);
            count(map, startX + length/2, startY, length/2);
            count(map, startX, startY + length/2, length/2);
            count(map, startX + length/2, startY + length/2, length/2);
        }else{
            if(std == 0) white ++;
            else blue ++;
        }
    }
}
