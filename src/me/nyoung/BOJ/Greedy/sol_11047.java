package me.nyoung.BOJ.Greedy;

import java.util.Scanner;

public class sol_11047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int goal = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if(goal >= arr[i]){
                count += goal/arr[i];
                goal %= arr[i];
            }
        }
        System.out.println(count);
    }
}
