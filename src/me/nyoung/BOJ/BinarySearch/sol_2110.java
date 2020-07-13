package me.nyoung.BOJ.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class sol_2110 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1] - arr[0];
        int max = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 1; //공유기 count
            int loc = arr[0] + mid;

            for (int i = 1; i < n; i++) {
                if(arr[i] >= loc) {
                    count++;
                    loc = arr[i] + mid;
                }
            }
            if(count >= c){
                left = mid + 1;
                if(max < mid) max = mid;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(max);
    }
}
