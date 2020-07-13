package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        if(n <= 3){
            if(n == 1) System.out.println(0);
            else System.out.println(1);
            return;
        }
        arr[2] = arr[3] = 1;

        for(int i = 4; i <= n; i++){
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
        }

        System.out.println(arr[n]);
    }
}
