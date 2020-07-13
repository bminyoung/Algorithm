package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_2579 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[301];
        int[] stair = new int[301];
        for(int i = 0; i < n; i++){
            stair[i] = sc.nextInt();
        }

        d[0] = stair[0];
        d[1] = stair[0] + stair[1];
        d[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for(int i = 3; i < n; i++){
            d[i] = Math.max(d[i-3] + stair[i-1] + stair[i], d[i-2] + stair[i]);
        }

        System.out.println(d[n-1]);
    }
}
