package me.nyoung.BOJ.BinarySearch;

import java.util.Scanner;

public class sol_2805 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = 2000000000;
        int max = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] > mid) sum += arr[i] - mid;
            }

            if(sum >= M){
                left = mid + 1;
                if(max < mid) max = mid;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(max);
    }
}
