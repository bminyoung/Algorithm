package me.nyoung.BOJ.BinarySearch;

import java.util.Scanner;

public class sol_1300 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int left = 1;
        int right = k;
        while(left < right){
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 1; i <= n; i++) {
                sum += Math.min(mid/i, n);
                if(sum > k) break;
            }

            if(sum < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(right);
    }
}
