package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n+2];
        int[] pay = new int[n+2];
        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        int[] d = new int[n+2];
        for (int i = n; i > 0; i--) {
            d[i] = d[i+1];
            int afterDay = time[i] + i;
            if(afterDay <= n+1){
                d[i] = Math.max(d[i], d[afterDay] + pay[i]);
            }
        }
        System.out.println(d[1]);
    }
}
