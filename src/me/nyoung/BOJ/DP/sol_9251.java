package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] first = sc.next().toCharArray();
        char[] second = sc.next().toCharArray();
        int[][] d = new int[first.length+1][second.length+1];

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if(first[i-1] == second[j-1]){
                    d[i][j] = d[i-1][j-1] + 1;
                }else{
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
                }
            }
        }
        System.out.println(d[first.length][second.length]);
    }
}
