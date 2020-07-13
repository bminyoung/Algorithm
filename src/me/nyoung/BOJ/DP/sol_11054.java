package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_11054 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] asc = new int[n];
        int[] des = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            asc[i] = des[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    asc[i] = Math.max(asc[i], asc[j] + 1);
                }
            }

            for(int j = n-1; j > n-i-1;j--){
                if(arr[j] < arr[n-i-1]){
                    des[n-i-1] = Math.max(des[n-i-1], des[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = asc[i] + des[i];
            if(sum > max) max = sum;
        }
        System.out.println(max-1);
    }
}
