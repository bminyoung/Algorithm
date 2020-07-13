package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_1904 {

    static final int div = 15746;

    public int solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        d[0] = d[1] = 1;

        for(int i = 2; i < n ; i++){
            d[i] = (d[i-1] + d[i-2]) % div;
        }

        return d[n-1];
    }
}
