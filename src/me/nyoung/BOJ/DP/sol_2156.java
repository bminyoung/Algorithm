package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        int[] alc = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            alc[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(alc[1]);
            return;
        }
        d[1] = alc[1];
        d[2] = alc[1] + alc[2];
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1];
            d[i] = Math.max(d[i], d[i - 3] + alc[i - 1] + alc[i]);
            d[i] = Math.max(d[i], d[i - 2] + alc[i]);
        }

        System.out.println(d[n]);
    }
}
