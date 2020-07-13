package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_9461 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int j = 0; j < T; j++){
            int n = sc.nextInt();
            long[] arr = new long[n];
            if(n < 5) arr = new long[5];
            arr[0] = arr[1] = arr[2] = 1;
            arr[3] = arr[4] = 2;
            if(n <= 5){
                System.out.println(arr[n-1]);
                continue;
            }
            for(int i = 5; i < n; i++){
                arr[i] = arr[i-1]+ arr[i-5];
            }
            System.out.println(arr[n-1]);
        }
    }
}
