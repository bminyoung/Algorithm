package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_11053 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] len = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            len[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
        }

        int max = len[0];
        for(int i = 1; i < n; i++){
            if(max < len[i]) max = len[i];
        }
        System.out.println(max);
    }
}
