package me.nyoung.BOJ.TwoPointer;

import java.util.Scanner;

public class sol_2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = 0, sum = arr[0], count = 0;
        while(right < n){
            if(sum >= m) {
                if(sum == m) count++;

                sum -= arr[left];
                left++;
            }
            else if(sum < m){
                right++;
                sum += arr[right];
            }
        }
        System.out.println(count);
    }
}
