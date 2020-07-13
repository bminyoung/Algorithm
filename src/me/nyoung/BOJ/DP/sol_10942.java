package me.nyoung.BOJ.DP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//care of timeout
public class sol_10942 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean[][] d = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            d[i][i] = true;
            if(i != n-1) d[i][i+1] = arr[i] == arr[i+1];
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j+i < n; j++) {
                d[j][j+i] = (d[j+1][j+i-1]) && (arr[j] == arr[j+i]);
            }
        }
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            if(d[sc.nextInt()-1][sc.nextInt()-1]) bw.write('1');
            else bw.write('0');
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
