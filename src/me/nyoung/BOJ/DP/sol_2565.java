package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[501];
        int[] asc = new int[501];
        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();
            arr[index] = sc.nextInt();
            asc[index] = 1;
        }

        int max = 0;
        for (int i = 2; i <= 500; i++) {
            for (int j = 1; j < i; j++) {
                if(arr[i] == 0 || arr[j] == 0) continue;

                if(arr[i] > arr[j]){
                    asc[i] = Math.max(asc[j] + 1, asc[i]);
                    if(max < asc[i]) max = asc[i];
                }
            }
        }
        System.out.println(n-max);
    }
}
