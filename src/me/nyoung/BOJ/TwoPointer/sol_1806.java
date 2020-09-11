package me.nyoung.BOJ.TwoPointer;

import java.util.Scanner;

public class sol_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int goal = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0, right = 0, sum = arr[0], min = n;
        while(right < n){
            if(sum >= goal){
                if(min > right-left) min = right-left;
                sum -= arr[left++];
            }else{
                sum += arr[++right];
            }
        }
        System.out.println(min == n ? 0 : min+1);
    }
}
